import java.util.logging.*;

public class PostSystem {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
    /*
    Interface: An entity that can be sent by mail. 
    Such an entity allows you to get from whom and 
    to whom the letter is directed.
    */
    public static interface Sendable {
        String getFrom();
        String getTo();
    }

    /*
    Abstract class: A class that allows abstracting 
    the logic of storing the sender and recipient of 
    the letter in the corresponding fields of the class.
    */
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    /*
    Letter: A letter that has a text that can be 
    obtained using the `getMessage` method.
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    /*
    Package: A package whose contents can be
    obtained using the `getContent` method.
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    /*
    Class that defines a package: A class that 
    defines a package. The package has a textual 
    description of the contents and an integer value. 
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    /*
    Interface: An interface that defines a class
    that can process a mail object in some way.
    */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    A class that hides the logic of real mail.
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Here is the code of the real mail sending system.
            return mail;
        }
    }


    /* Solution below: */

    /**
     * A thief who steals the most valuable packages and ignores all others.
     * The thief steals packages whose value is above a specified threshold.
     * <p>The class provides a method to retrieve the total value of stolen packages.</p>
     * 
     * @see Package
     */
    public static class Thief implements MailService {
        private final int minPrice;
        private int stolenSum;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
            this.stolenSum = 0;
        }

        public int getStolenValue() {
            return stolenSum;
        }
        
        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() != MailPackage.class) return mail;
            MailPackage mailPack = (MailPackage)mail;
            Package pack = mailPack.getContent();
            if (pack.price < minPrice) return mail;
            stolenSum += pack.price;
            Package emptyPack = new Package("stones instead of " + pack.getContent(), 0);
            MailPackage emptyMailPack = new MailPackage(mailPack.from, mailPack.to, emptyPack);
            return emptyMailPack;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {}
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {}
    }

    /**
     * An inspector who monitors prohibited and stolen packages.
     * If a prohibited package or a stolen package is detected, an exception is raised.
     * 
     * @see IllegalPackageException
     * @see StolenPackageException
     */
    public static class Inspector implements MailService{

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() != MailPackage.class) return mail;
            MailPackage mailPack = (MailPackage)mail;
            String mailContent = mailPack.getContent().getContent();
            if (mailContent.contains(WEAPONS) 
                || mailContent.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            if (mailContent.contains("stones")) {
                throw new StolenPackageException();
            }
            return mailPack;
        }
    }

    /**
     * A class that simulates an unreliable postal worker.
     * The UntrustworthyMailWorker processes mail by passing it sequentially 
     * through a series of services, and finally sends the resulting object 
     * to the RealMailService.
     * 
     * <p>The constructor accepts an array of MailService objects, and the result 
     * of the first `processMail` call is passed to the second, and so on.</p>
     * 
     * @see MailService
     * @see RealMailService
     */
    public static class UntrustworthyMailWorker implements MailService {
        private final MailService[] sideServices;
        private final RealMailService realPost;

        public UntrustworthyMailWorker(MailService[] services) {
            this.sideServices = services;
            this.realPost = new RealMailService();
        }

        public MailService[] getServices() {
            return sideServices;
        }

        public RealMailService getRealMailService() {
            return realPost;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable temp = sideServices[0].processMail(mail);
            for (int i = 1; i < sideServices.length; i++) {
                temp = sideServices[i].processMail(temp);
            }
            return this.getRealMailService().processMail(temp);            
        }
    }

    /**
     * A spy that logs all mail correspondence passing through his hands.
     * The spy monitors only MailMessage objects and logs the following messages:
     * <ul>
     *   <li>If the sender or recipient is "Austin Powers", it logs a WARN message.</li>
     *   <li>Otherwise, it logs an INFO message for usual correspondence.</li>
     * </ul>
     * 
     * @see Logger
     * @see MailMessage
     */
    public static class Spy implements MailService{
        private Logger LOGGER;

        public Spy(Logger LOGGER) {
            this.LOGGER = LOGGER;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail.getClass() != MailMessage.class) return mail;
            MailMessage letter = (MailMessage)mail;
            String from = letter.getFrom();
            String to = letter.getTo();
            String msg = letter.getMessage();
            if (from.contains(AUSTIN_POWERS) || to.contains(AUSTIN_POWERS)) {
                LOGGER.log(Level.WARNING, 
                            String.format("Detected target mail correspondence: from %s to %s \"%s\"", 
                            from, to, msg));
            }
            else LOGGER.log(Level.INFO, String.format("Usual correspondence: from %s to %s",
                            from, to));
            return mail;
        }
    }

    public static void main(String[] args) {
        // Step 1: Set up the services (Inspector, Thief, UntrustworthyMailWorker)
        Inspector inspector = new Inspector();
        Thief thief = new Thief(30);
        Logger LOGGER = Logger.getLogger(Spy.class.getName());
        Spy spy = new Spy(LOGGER);
        MailService[] services = new MailService[]{inspector, thief, spy};
        UntrustworthyMailWorker untrustWorker = new UntrustworthyMailWorker(services);

        // Step 2: Create a package to be sent and wrap it in a MailPackage
        Package box = new Package("expensive clothes", 120);
        MailPackage sentBox = new MailPackage("Mary Brown", "Peter Fox", box);
        System.out.println(String.format("Sent Package: %s, price: %s", box.getContent(), box.price));

        // Step 3: Process the package through UntrustworthyMailWorker (multiple services)
        MailPackage receivedBox = (MailPackage)untrustWorker.processMail(sentBox);
        System.out.println(String.format("Received Package: %s, price: %s\n", receivedBox.getContent().getContent(), receivedBox.getContent().price));

        // Step 4: Create a letter to be sent and wrap it in a MailMessage
        MailMessage sentLetter = new MailMessage("Mimi Petite", "Selene Lee", "Salut from Paris! It's sunny today.");

        // Step 4: Create a letter with target AUSTIN_POWERS to be sent and wrap it in a MailMessage
        MailMessage susLetter = new MailMessage(AUSTIN_POWERS, "Mimi Petite", "Got your code.");

        // Step 4: Process the letter through UntrustworthyMailWorker (multiple services)
        untrustWorker.processMail(sentLetter);
        untrustWorker.processMail(susLetter);
    }
}
