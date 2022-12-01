public class PositiveNumber {
	private int value;

	public static void main(String[] args) {
		PositiveNumber n = new PositiveNumber();
		n.setHexadecimal("A9");
		System.out.println(n.value);
		System.out.println(n.getHexadecimal());
		n.setBinary("101");
		System.out.println(n.getBinary());
		System.out.println(n.value);

	}

	public void setDecimal(String s) {
		int x = Integer.parseInt(s);
		if (x > 0) {
			this.value = x;
		} else {
			throw new ArithmeticException("Fehlerhafte Eingabe");
		}
	}

	public void setHexadecimal(String s) {
		int x = 0;
		int exp = s.length() - 1;
		for (int i = 0; i < s.length(); i++) {
			s = s.toUpperCase();
			if (s.charAt(i) > 64 && s.charAt(i) < 71) {
				x += Math.pow(16, exp) * (s.charAt(i) - 55);
			} else if (Character.isDigit(s.charAt(i))) {
				x += Math.pow(16, exp) * Character.getNumericValue(s.charAt(i));

			} else {
				throw new NumberFormatException("keine Zahl");
			}
			exp--;
		}
		this.value = x;
	}

	public void setBinary(String s) {
		int x = 0;
		int exp = s.length() - 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0' && s.charAt(i) != '1') {
				throw new ArithmeticException("Verdammte Scheisse");
			}

			if (s.charAt(i) == '1') {
				x += Math.pow(2, exp);
			}
			exp--;
		}
		this.value = x;

	}

	public String getDecimal() {
		return Integer.toString(this.value);
	}

	public String getHexadecimal() {
		int x = this.value;
		StringBuilder output = new StringBuilder();
		while(x>0) {
			output.insert(0,toHex(x%16));
			x /= 16;
		}
		
		return output.toString();
	}
	private static char toHex(int x) {
		if(x>9) {
			return (char) (x+55);
		}
		return (char)(x+48);
	}

	public String getBinary() {
		int x = this.value;
		StringBuilder output = new StringBuilder();
		while(x>0) {
			output.insert(0,x%2);
			x /= 2;
		}

		return output.toString();
	}
}
