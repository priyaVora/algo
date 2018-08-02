package vora.priya.assignmentOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubnetMaskUtilityTester {
	private static String ipAddressOne = "";
	private static String ipAddressTwo = "";
	private static String subnetMask;

	public static void main(String[] args) throws IOException {
		start();
	}

	private static void start() throws IOException {

		String[] ipOne = promptUserForIPAddressOne();
		String[] subnetMaskArray = promptUserForSubnetMask();
		String[] ipTwo = promptUserForIPAddressTwo();
		int subnetOne = findSubnet(ipAddressOne, ipOne, subnetMaskArray);
		int subnetTwo = findSubnet(ipAddressTwo, ipTwo, subnetMaskArray);
		compareSubnet(subnetOne, subnetTwo);
	}

	public static boolean compareSubnet(int subnetOne, int subnetTwo) {
		boolean matched = false;
		System.out.println(" ");
		if (subnetOne == subnetTwo) {
			System.out.println(" Network Addresses Match...!");
			matched = true;
		} else {
			System.out.println(" Network Addresses Do Not Match...!");
			matched = false;
		}
		return matched;
	}

	public static Integer findSubnet(String ip, String[] ipArray, String[] subnetMaskArray) {
		Integer subnet = null;
		String subnetString = "";
		if (subnetMask != null || subnetMask != "") {
			System.out.println("\nSubnet:");
			for (int i = 0; i < ipArray.length; i++) {
				subnet = Integer.parseInt(ipArray[i]) & Integer.parseInt(subnetMaskArray[i]);
				subnetString += " ";
				subnetString += subnet;
				System.out.print(subnet + " ");
				subnetString = subnetString.trim();
				subnetString = subnetString.replace(" ", ".");
			}
		}
		return subnet;
	}

	private static String[] promptUserForSubnetMask() throws IOException {
		boolean end = false;
		String[] subnetMaskSplit = null;
		while (end == false) {
			try {
				System.out.println("\nEnter a subnet mask in IP Address Format: \n");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String s = br.readLine();
				s = s.trim();

				subnetMaskSplit = s.split("\\.");

				if (checkIfValidSubnetMask(s, subnetMaskSplit) == true) {
					System.out.println(" STATUS: Valid IP Address...");
					subnetMask = s;
					end = true;
				} else {
					System.out.println(" STATUS: Invalid IP Address...");
				}
			} catch (NumberFormatException e) {
				end = false;
			}
		}

		return subnetMaskSplit;
	}

	private static String[] promptUserForIPAddressOne() throws IOException {
		String[] ipOne = iPAddressHelper();
		for (String octect : ipOne) {
			ipAddressOne += octect;
			ipAddressOne += " ";
		}
		ipAddressOne = ipAddressOne.trim();
		ipAddressOne = ipAddressOne.replace(" ", ".");
		System.out.println(" IP ADDRESS ONE: " + ipAddressOne);
		return ipOne;
	}

	private static String[] promptUserForIPAddressTwo() throws IOException {
		String[] ipTwo = iPAddressHelper();
		for (String octect : ipTwo) {
			ipAddressTwo += octect;
			ipAddressTwo += " ";
		}
		ipAddressTwo = ipAddressTwo.trim();
		ipAddressTwo = ipAddressTwo.replace(" ", ".");
		System.out.println(" IP ADDRESS TWO: " + ipAddressTwo);
		return ipTwo;
	}

	private static String[] iPAddressHelper() throws IOException {

		boolean end = false;
		String[] ipAddressSplit = { "", "", "", "" };
		while (end == false) {
			try {
				System.out.println("\nPlease enter an IPV4 Network Address below: \n");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String s = br.readLine();
				s = s.trim();

				ipAddressSplit = s.split("\\.");

				if (checkIfValidIPAddress(s, ipAddressSplit) == true) {
					System.out.println(" STATUS: Valid IP Address...");
					end = true;
				} else {
					System.out.println(" STATUS: Invalid IP Address...");
					end = false;
				}
			} catch (NumberFormatException e) {
				end = false;
			}
		}
		return ipAddressSplit;
	}

	public static boolean checkIfValidIPAddress(String userInput, String[] ipAddressSplit) {
		if (ipAddressSplit.length > 4) {
			return false;
		}
		String[] tempArray = { "", "", "", "" };
		for (int i = 0; i < ipAddressSplit.length; i++) {
			tempArray[i] = ipAddressSplit[i];
		}
		for (String octect : tempArray) {
			if (octect == "") {
				return false;
			}
		}
		boolean valid = false;
		if (userInput != null || userInput != "") {
			for (String octet : ipAddressSplit) {
				if (Integer.parseInt(octet) >= 0 && Integer.parseInt(octet) <= 255) {
					valid = true;
				} else {
					valid = false;
					return valid;
				}
			}
		}
		return valid;
	}

	public static boolean checkIfValidSubnetMask(String userInput, String[] subnetMask) {
		if (subnetMask.length > 4) {
			return false;
		}
		String[] tempArray = { "", "", "", "" };
		for (int i = 0; i < subnetMask.length; i++) {
			tempArray[i] = subnetMask[i];
		}
		for (String octect : tempArray) {
			if (octect == "") {
				return false;
			}
		}
		boolean valid = false;
		if (userInput != null || userInput != "") {
			for (String octet : subnetMask) {
				if (Integer.parseInt(octet) >= 0 && Integer.parseInt(octet) <= 255) {
					String binaryOctet = convertAddressToBinaryFormat(Integer.parseInt(octet));
					if (binaryOctet.contains("01")) {
						valid = false;
						return valid;
					} else {
						valid = true;
					}
				}
			}
		}
		return valid;
	}

	public static String convertAddressToBinaryFormat(int octet) {
		String binaryRepresentation = Integer.toBinaryString(octet);
		return binaryRepresentation;
	}

}
