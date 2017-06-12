package AlgorithmDSLeetCode;

public class ReverseString {

	public String reverseString(String s) {

		char[] c = s.toCharArray();

		StringBuilder sb = new StringBuilder();

		for (int i = c.length - 1; i >= 0; i--)
			sb.append(c[i]);
		return sb.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseString().reverseString("NitinisDeep..."));
	}

}
