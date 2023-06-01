package io.github.superjoy0502.paralleldatastructureproject;

import java.time.LocalDate;
import java.util.ArrayList;

public class AlgorithmHandler {
    public ArrayList<String> bubbleSortString(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size() - i - 1; j++) {
                if (arrayList.get(j).compareTo(arrayList.get(j + 1)) > 0) {
                    String temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<LocalDate> bubbleSortDate(ArrayList<LocalDate> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size() - i - 1; j++) {
                if (arrayList.get(j).isAfter(arrayList.get(j + 1))) {
                    LocalDate temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
        return arrayList;
    }

    public int binarySearch(ArrayList<String> arrayList, String target) {
        int low = 0;
        int high = arrayList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arrayList.get(mid).compareTo(target) < 0) {
                low = mid + 1;
            } else if (arrayList.get(mid).compareTo(target) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearch(ArrayList<LocalDate> arrayList, LocalDate target) {
        int low = 0;
        int high = arrayList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arrayList.get(mid).isBefore(target)) {
                low = mid + 1;
            } else if (arrayList.get(mid).isAfter(target)) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
