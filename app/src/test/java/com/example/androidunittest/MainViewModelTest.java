package com.example.androidunittest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MainViewModelTest {
    private MainViewModel viewModel;

    @Before
    public void setUp() {
        // Inisialisasi ViewModel sebelum setiap pengujian
        viewModel = new MainViewModel();
    }

    @Test
    public void testConvertToUpperCase() {
        /*
         * Test Case 1: Memeriksa apakah fungsi convertToUpperCase()
         * mengubah teks menjadi huruf besar dengan benar.
         *
         * Tujuan:
         * - Memverifikasi bahwa metode convertToUpperCase() dapat mengubah string
         *   dengan berbagai karakter huruf kecil menjadi huruf kapital.
         * - Memastikan metode dapat menangani kasus edge seperti input null dengan benar.
         *
         * Test Scenario:
         * 1. Input string sederhana dengan semua huruf kecil "hello" -> "HELLO"
         * 2. Input string yang lebih panjang "android" -> "ANDROID"
         * 3. Input null -> "" (string kosong)
         *
         * Expected Result:
         * - String output harus berisi karakter yang sama dengan input tetapi dalam
         *   bentuk huruf kapital.
         * - Ketika input null, metode harus mengembalikan string kosong sebagai penanganan
         *   defensive programming untuk mencegah NullPointerException.
         */
        assertEquals("HELLO", viewModel.convertToUpperCase("hello")); // "hello" → "HELLO"
        assertEquals("ANDROID", viewModel.convertToUpperCase("android")); // "android" → "ANDROID"
        assertEquals("", viewModel.convertToUpperCase(null)); // null → ""
    }

    @Test
    public void testConvertToUpperCase_withNumbers() {
        /*
         * Test Case 2: Memeriksa apakah angka tidak terpengaruh oleh fungsi.
         * Seharusnya angka tetap sama, hanya huruf yang berubah menjadi kapital.
         *
         * Tujuan:
         * - Memverifikasi bahwa metode convertToUpperCase() hanya mengubah
         *   karakter alfabet (huruf), sedangkan karakter non-alfabet (seperti angka)
         *   tidak berubah.
         * - Memastikan bahwa metode bekerja dengan benar untuk input campuran yang
         *   berisi huruf dan angka.
         *
         * Test Scenario:
         * 1. Input string yang hanya berisi angka "123" -> "123"
         * 2. Input string campuran huruf dan angka "hello123" -> "HELLO123"
         *
         * Expected Result:
         * - Karakter angka dalam string harus tetap tidak berubah.
         * - Hanya karakter huruf yang dikonversi menjadi huruf kapital.
         * - String yang hanya berisi angka harus tetap identik setelah diproses.
         * - String campuran harus memiliki hurufnya dikonversi tetapi angkanya tetap sama.
         *
         * Signifikansi:
         * Test ini memastikan bahwa fungsi convertToUpperCase() hanya memproses
         * karakter yang relevan (huruf) dan meninggalkan karakter lain (seperti angka)
         * tidak berubah, yang penting untuk menjaga integritas data dalam aplikasi.
         */
        assertEquals("123", viewModel.convertToUpperCase("123")); // "123" → "123"
        assertEquals("HELLO123", viewModel.convertToUpperCase("hello123")); // "hello123" → "HELLO123"
    }
}