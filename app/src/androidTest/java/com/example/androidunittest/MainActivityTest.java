package com.example.androidunittest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testButtonClick_ConvertsTextToUpperCase() {
        /*
         * Test Case 1: Menginput teks "hello" pada EditText, lalu klik tombol.
         * Setelah tombol diklik, teks dalam TextView seharusnya berubah menjadi "HELLO".
         *
         * Tujuan:
         * - Memverifikasi bahwa UI aplikasi berfungsi sesuai dengan harapan saat user memasukkan teks
         *   dan menekan tombol konversi.
         * - Memastikan bahwa alur kerja aplikasi (input → proses → output) berjalan dengan benar.
         * - Memeriksa integrasi antara UI (Activity) dengan logika bisnis (ViewModel) bekerja dengan baik.
         *
         * Komponen yang diuji:
         * - EditText (ID: R.id.editText) - komponen input user
         * - Button (ID: R.id.button) - komponen untuk memicu aksi konversi
         * - TextView (ID: R.id.textView) - komponen untuk menampilkan hasil konversi
         *
         * Langkah-langkah pengujian:
         * 1. Memasukkan string "hello" ke dalam EditText menggunakan Espresso
         * 2. Mensimulasikan klik pada tombol konversi menggunakan Espresso
         * 3. Memeriksa apakah TextView menampilkan hasil konversi yang benar ("HELLO")
         *
         * Expected Result:
         * - TextView harus menampilkan teks "HELLO" setelah tombol diklik
         * - Ini membuktikan bahwa aplikasi berhasil mengambil input, memprosesnya, dan
         *   menampilkan output yang benar
         *
         * Signifikansi:
         * Test ini memvalidasi pengalaman pengguna dasar dalam aplikasi dan memastikan
         * bahwa fitur utama (konversi teks) berfungsi dengan benar dari perspektif UI.
         */

        // Input teks "hello" ke dalam EditText
        onView(withId(R.id.editText)).perform(replaceText("hello"));

        // Klik tombol
        onView(withId(R.id.button)).perform(click());

        // Pastikan teks berubah menjadi "HELLO"
        onView(withId(R.id.textView)).check(matches(withText("HELLO")));
    }

    @Test
    public void testButtonClick_WithNumbers() {
        /*
         * Test Case 2: Menginput teks "android123" pada EditText, lalu klik tombol.
         * Setelah tombol diklik, teks dalam TextView seharusnya berubah menjadi "ANDROID123".
         *
         * Tujuan:
         * - Memverifikasi bahwa aplikasi dapat menangani teks campuran yang berisi
         *   huruf dan angka dengan benar.
         * - Memastikan implementasi UI konsisten dengan spesifikasi fungsional
         *   (hanya mengubah huruf, bukan angka).
         * - Menguji kasus penggunaan yang lebih kompleks dengan input campuran.
         *
         * Komponen yang diuji:
         * - EditText (ID: R.id.editText) - untuk memasukkan teks campuran
         * - Button (ID: R.id.button) - untuk mengaktifkan proses konversi
         * - TextView (ID: R.id.textView) - untuk menampilkan hasil konversi
         *
         * Langkah-langkah pengujian:
         * 1. Memasukkan string campuran "android123" ke dalam EditText
         * 2. Mensimulasikan klik pada tombol konversi
         * 3. Memeriksa apakah TextView menampilkan teks "ANDROID123" setelah konversi
         *
         * Expected Result:
         * - TextView harus menampilkan teks "ANDROID123" yang menunjukkan bahwa
         *   huruf telah dikonversi ke kapital sementara angka tetap tidak berubah
         *
         * Signifikansi:
         * - Test ini memastikan bahwa aplikasi menangani dengan benar input yang lebih kompleks
         * - Memvalidasi bahwa aturan bisnis (hanya mengubah huruf, biarkan angka tetap)
         *   diimplementasikan dengan benar pada tingkat UI
         * - Memverifikasi konsistensi antara unit test logika bisnis dengan perilaku UI aktual
         *
         * Teknik pengujian:
         * Test ini menggunakan Espresso framework untuk Android UI testing yang memungkinkan
         * kita mensimulasikan interaksi user dan memverifikasi perubahan UI yang dihasilkan.
         * Pendekatan ini memungkinkan pengujian end-to-end pada komponen visual aplikasi.
         */

        // Input teks "android123" ke dalam EditText
        onView(withId(R.id.editText)).perform(replaceText("android123"));

        // Klik tombol
        onView(withId(R.id.button)).perform(click());

        // Pastikan teks berubah menjadi "ANDROID123"
        onView(withId(R.id.textView)).check(matches(withText("ANDROID123")));
    }
}

