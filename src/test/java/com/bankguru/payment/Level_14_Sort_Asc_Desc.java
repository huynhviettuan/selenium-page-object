package com.bankguru.payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_14_Sort_Asc_Desc {
	WebDriver driver;

	@BeforeClass
	public void initData(String browserName) {

	}

	@Test
	public void f() {

	}

	public boolean isDataSortedAscending(WebDriver driver, String locator) {
		// Khai báo 1 array list
		ArrayList<String> arrayList = new ArrayList<>();

		// Tìm tất cả element matching với điều kiện (name,price,..)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lấy từng text của element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("Dữ liệu trên UI");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Copy qua 1 array list mới để SORT trong code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(arrayList);

		System.out.println("Dữ liệu đã SORT trong code");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Verify 2 array bằng nhau - nếu dữ liệu sort trên UI không chính xác thì kết quả trả về sai
		return sortedList.equals(arrayList);
	}

	public boolean isDataSortedDescending(WebDriver driver, String locator) {
		// Khai báo 1 array list
		ArrayList<String> arrayList = new ArrayList<>();

		// Tìm tất cả element matching với điều kiện (name,price,..)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lấy từng text của element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("Dữ liệu trên UI");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Copy qua 1 array list mới để SORT trong code
		ArrayList<String> sortedList = new ArrayList<>();
		for (String child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(arrayList);

		System.out.println("Dữ liệu đã SORT trong code");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Reverse data để sort DESC
		Collections.reverse(arrayList);
		// Cách 2 Collections.sort(arrayList,Collections.reverseOrder());
		System.out.println("Dữ liệu đã SORT DESC trong code");
		for (String name : arrayList) {
			System.out.println(name);
		}

		// Verify 2 array bằng nhau - nếu dữ liệu sort trên UI không chính xác thì kết quả trả về sai
		return sortedList.equals(arrayList);
	}

	// Sort Java 8
	public boolean isDataSortedAsc(WebDriver driver, String locator) {
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		List<String> names = elementList.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String> sortedNames = names;
		Collections.sort(sortedNames);
		return names.equals(sortedNames);
	}

	// Sort float
	public boolean isPriceSortedAscending(WebDriver driver, String locator) {
		// Khai báo 1 array list
		ArrayList<Float> arrayList = new ArrayList<Float>();

		// Tìm tất cả element matching với điều kiện (name,price,..)
		List<WebElement> elementList = driver.findElements(By.xpath(locator));

		// Lấy từng text của element add vào Array List
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}

		System.out.println("Dữ liệu trên UI");
		for (Float name : arrayList) {
			System.out.println(name);
		}

		// Copy qua 1 array list mới để SORT trong code
		ArrayList<Float> sortedList = new ArrayList<>();
		for (Float child : arrayList) {
			sortedList.add(child);
		}

		Collections.sort(arrayList);

		System.out.println("Dữ liệu đã SORT trong code");
		for (Float name : arrayList) {
			System.out.println(name);
		}

		// Verify 2 array bằng nhau - nếu dữ liệu sort trên UI không chính xác thì kết quả trả về sai
		return sortedList.equals(arrayList);
	}
}
