package com.kevin.arithmetic;

/**
 * Kevin-Tu on 2018/5/14.
 */
public class Solution {

    public static void main(String[] args) {
        String result = solution("228 858 186 957 195 905 646 147 384 744 246 919 210 562 102 199 962 928 631 605 521 942 142 49 235 601 730 136 730 832 413 998 998 321 860 682 196 115 209 93 410 472 719 500 645 132 489 386 800 449 678 63 928 988 514 753 868 285 682 431 699 919 375 723 705 321 51 480 779 718 631 672 532 370 345 563 942 365 16 856 533 756 644 604 143 304 262 994 895 210 60 415 341 772 652 217 996 113 835 917 733 204 126 433 980 907 327 659 808 96 64 228 551 49 850 222 901 616 110 895 700 67 319 468 110 653 970 723 883 935 554 987 102 24 923 326 249 727 785 775 127 281 403 902 110 472 431 168 215 704 756 913 200 729 927 440 358 21 86 162 690 562 859 693 655 938 501 945 307 75 678 293 825 561 30 921 51 844 835 492 628 457 827 952 587 140 911 896 458 322 669 274 910 238 929 431 489 364 748 624 922 584 407 241 233 31 85 138 860 403 393 668 550 986 416 967 654 312 321 618 546 609 129 753 607 275 771 536 935 3 374 520 163 788 87 3 105 555 482 488 89 921 616 406 195 311 206 510 878 772 74 970 102 330 838 810 333 860 177 679 632 79 289 456 990 665 206 410 456 293 122 909 820 911 355 110 28 156 628 521 564 161 309 128 275 582 738 202 493 35 839 645 564 376 28 272 222 588 432 192 162 218 373 28 577 411 624 309 731 474 431 461 667 721 229 964 138 235 13 101 184 430 996 872 457 145 481 161 989 818 80 971 316 374 914 353 731 408 719 283 977 26 876 746 557 288 151 523 323 363 609 193 137 920 44 507 581 917 656 158 353 855 52 445 884 307 657 747 375 533 471 398 305 897 102 311 79 181 720 702 138 569 275 665 928 109 818 964 149 776 85 428 813 840 93 730 909 977 914 409 177 941 342 466 69 916 615 432 347 312 109 496 170 923 740 849 410 399 930 379 8 715 12 977 890 831 805 255 498 509 387 832 561 859 694 123 818 180 580 962 587 862 804 49 487 139 370 828 719 834 399 909 958 239 75 917 246 841 669 136 450 88 828 836 40 840 137 385 603 606 641 826 587 130 674 36 720 883 922 92 460 55 951 196 897 644 174 96 154 300 188 752 436 537 869 299 102 749 240 455 148 464 946 989 370 860 332 193 740 262 799 995 658 349 460 928 807 940 269 577 645 442 7 715 933 538 508 486 972 850 971 801 495 735 935 504 174 848 838 48 919 274 42 852 355 991 124 671 265 492 251 931 340 398 394 331 416 334 310 765 958 774 672 909 521 677 7 214 852 895 340 235 645 960 280 533 673 365 408 760 968 536 162 780 453 787 884 178 440");
        System.out.print(result);
    }

    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" ");
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for (String numberStr : array) {
            Integer number = Integer.valueOf(numberStr);
            Integer lastTimes = map.get(number);
            if (lastTimes == null) {
                map.put(number, 1);
            } else {
                map.put(number, ++lastTimes);
            }
        }
        int maxNumber = 0;
        for (java.util.Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int sum = entry.getKey() * entry.getValue();
            Integer nextNumberTimes = map.get(entry.getKey() + 1);
            if (nextNumberTimes != null) {
                sum += entry.getKey() * nextNumberTimes;
            }
            if (sum > maxNumber) {
                maxNumber = sum;
            }
        }
        // 返回处理后的结果
        return String.valueOf(maxNumber);
    }
}
