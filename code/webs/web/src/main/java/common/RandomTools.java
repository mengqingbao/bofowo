package common;

import java.util.Random;


/**
 * 生成随机数
 * 
 * @author liguoxiang
 * 
 */
public class RandomTools {
	/**
	 * 数字集合
	 */
	private static final String[] NUMS = { "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "0" };
	/**
	 * 大写字母集合
	 */
	private static final String[] UPPERS = { "A", "B", "C", "D", "E", "F", "G",
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };
	/**
	 * 小写字母集合
	 */
	private static final String[] LOWERS = { "a", "b", "c", "d", "e", "f", "g",
			"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z" };

	/**
	 * 生成随机(32-64)长度随机字符串（必须包含大小写字母和数字）
	 * 
	 * @return 随机字符串
	 */
	public static String GenerateRandom() {
		try {
			int numCount = 0; // 已随机生成数字个数
			int upperCount = 0; // 已随机生成大写字母个数
			int lowerCount = 0; // 已随机生成小写字母个数

			StringBuilder sb = new StringBuilder();
			// 随机字符串长度
			int length = GetRandom(32, 64);
			// 生成类型
			StringBuilder charOrNum = new StringBuilder();
			for (int i = 1; i <= length; i++) {
				if (i > length - 2) {
					if (numCount == 0) {
						charOrNum.append("num");
						sb.append(GetRandom(charOrNum));
					} else if (upperCount == 0) {
						charOrNum.append("upper");
						sb.append(GetRandom(charOrNum));
					} else if (lowerCount == 0) {
						charOrNum.append("lower");
						sb.append(GetRandom(charOrNum));
					} else {
						sb.append(GetRandom(charOrNum));
					}
				} else {
					sb.append(GetRandom(charOrNum));
				}
				if (charOrNum.toString().equalsIgnoreCase("num")) {
					numCount++;
				} else if (charOrNum.toString().equalsIgnoreCase("upper")) {
					upperCount++;
				} else if (charOrNum.toString().equalsIgnoreCase("lower")) {
					lowerCount++;
				}
				charOrNum.delete(0, charOrNum.length());
			}
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 生成一个随机字符
	 * 
	 * @param charOrNum
	 *            随机生成类型：upper大写字母，lower小写字母，num数字，否则三种类型随机生成
	 * @return 随机字符
	 */
	public static String GetRandom(StringBuilder charOrNum) {
		Random random = new Random();
		// 输出字母还是数字
		if ("num".equalsIgnoreCase(charOrNum.toString())) {
			// 数字
			return NUMS[random.nextInt(NUMS.length)];
		} else if ("upper".equalsIgnoreCase(charOrNum.toString())) {
			// 大写字母
			return UPPERS[random.nextInt(UPPERS.length)];
		} else if ("lower".equalsIgnoreCase(charOrNum.toString())) {
			// 小写字母
			return LOWERS[random.nextInt(LOWERS.length)];
		} else {
			switch (random.nextInt(3)) {
			case 0:
				charOrNum.append("num");
				break;
			case 1:
				charOrNum.append("upper");
				break;
			default:
				charOrNum.append("lower");
				break;
			}
			return GetRandom(charOrNum);
		}
	}

	/**
	 * 生成一个min到max之间的随机数
	 * 
	 * @param min
	 *            最小
	 * @param max
	 *            最大
	 * @return
	 */
	public static int GetRandom(int min, int max) {
		Random random = new Random();
		int length = random.nextInt(max + 1);
		if (length < min) {
			return GetRandom(min, max);
		} else {
			return length;
		}
	}
}
