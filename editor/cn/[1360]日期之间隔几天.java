//请你编写一个程序来计算两个日期之间隔了多少天。 
//
// 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。 
//
// 
//
// 示例 1： 
//
// 输入：date1 = "2019-06-29", date2 = "2019-06-30"
//输出：1
// 
//
// 示例 2： 
//
// 输入：date1 = "2020-01-15", date2 = "2019-12-31"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 给定的日期是 1971 年到 2100 年之间的有效日期。 
// 
//
// Related Topics 数学 字符串 👍 48 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");

        int year1 = Integer.parseInt(d1[0]);
        int year2 = Integer.parseInt(d2[0]);

        int month1 = Integer.parseInt(d1[1]);
        int month2 = Integer.parseInt(d2[1]);

        int day1 = Integer.parseInt(d1[2]);
        int day2 = Integer.parseInt(d2[2]);

        int days1 = 0, days2 = 0;
        for (int i = 1971; i < year1 || i < year2; i++) {
            if (i < year1) {
                if (isLeapYear(i)) {
                    days1 += 366;
                } else {
                    days1 += 365;
                }
            }
            if (i < year2) {
                if (isLeapYear(i)) {
                    days2 += 366;
                } else {
                    days2 += 365;
                }
            }
        }


        for (int i = 1; i < month1 || i < month2; i++) {
            if (i < month1) {
                days1 += dayOfMonth[i - 1];
            }
            if (i < month2) {
                days2 += dayOfMonth[i - 1];
            }
        }

        if (month1 > 2 && isLeapYear(year1)) {
            days1 += 1;
        }
        if (month2 > 2 && isLeapYear(year2)) {
            days2 += 1;
        }

        return Math.abs(days1 + day1 - (days2 + day2));
    }

    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return  false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
