public class CamelCase {
	public static String camelCase(String input) {
		int i = 0;
		String result = "";
		while (i < input.length() - 1) {
			result += input.charAt(i);
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z'
			&& input.charAt(i + 1) >= 'A' && input.charAt(i + 1) <= 'Z') {
				result += " ";
			}
			i++;
		}
		if (i == input.length() - 1) {
			result += input.charAt(i);
		}
		return result;
	}

	public static String alternCamelCase(String input) {
		String[] components;
		components = input.split("(?<=[a-z])(?=[A-Z])");
		return String.join(" ", components);
	}

	public static void main(String[] arguments) {
		System.out.println(alternCamelCase("camelCasting"));
		System.out.println(alternCamelCase("camelCasingTest"));
		System.out.println(alternCamelCase("camelcasingtest"));
	}
}
