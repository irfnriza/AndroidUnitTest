Android Testing Demo
Repositori ini berisi contoh implementasi pengujian pada aplikasi Android, mendemonstrasikan praktik terbaik untuk Local Unit Test dan Instrumented UI Test.
Gambaran Umum
Aplikasi demo ini memiliki fungsionalitas sederhana untuk mengubah teks menjadi huruf kapital. Meskipun sederhana, aplikasi ini menunjukkan struktur pengujian yang komprehensif yang dapat diterapkan pada aplikasi Android yang lebih kompleks.
Struktur Aplikasi

MainActivity: Activity utama yang menampilkan UI dengan EditText untuk input, Button untuk memicu konversi, dan TextView untuk menampilkan hasil.
MainViewModel: ViewModel yang berisi logika bisnis untuk mengubah teks menjadi huruf kapital.

Strategi Pengujian
Repositori ini menerapkan dua jenis pengujian:
1. Local Unit Test
Local Unit Test berjalan pada JVM lokal dan digunakan untuk menguji logika bisnis tanpa ketergantungan pada framework Android.
File: MainViewModelTest.java
Test Case:

testConvertToUpperCase(): Menguji konversi teks biasa menjadi huruf kapital dan penanganan input null.
testConvertToUpperCase_withNumbers(): Menguji bahwa angka tidak terpengaruh oleh fungsi konversi huruf kapital.

2. Instrumented UI Test
Instrumented Test berjalan pada perangkat Android atau emulator dan digunakan untuk menguji interaksi UI dan integrasi antar komponen.
File: MainActivityTest.java
Test Case:

testButtonClick_ConvertsTextToUpperCase(): Menguji alur interaksi dasar pengguna dengan memasukkan teks "hello" dan memverifikasi output "HELLO".
testButtonClick_WithNumbers(): Menguji penanganan input campuran huruf dan angka ("android123") pada tingkat UI.

Cara Menjalankan Pengujian
Menjalankan Local Unit Test
bashCopy./gradlew test
atau dari Android Studio:

Klik kanan pada file MainViewModelTest.java
Pilih "Run MainViewModelTest"

Menjalankan Instrumented Test
bashCopy./gradlew connectedAndroidTest
atau dari Android Studio:

Klik kanan pada file MainActivityTest.java
Pilih "Run MainActivityTest"

Dependensi Pengujian
gradleCopydependencies {
    // Unit testing
    testImplementation 'junit:junit:4.13.2'
    
    // Instrumented testing
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation 'androidx.test:rules:1.5.0'
}
Praktik Terbaik yang Didemonstrasikan

Pemisahan Concern: Logika bisnis dalam ViewModel terpisah dari UI, memungkinkan pengujian unit yang lebih mudah.
Test Coverage Komprehensif: Pengujian dilakukan baik pada level unit (logika bisnis) maupun pada level UI.
Penanganan Kasus Khusus: Pengujian mencakup kasus normal, kasus khusus (null), dan variasi input (campuran huruf dan angka).
Dokumentasi Test Case: Setiap test case memiliki dokumentasi yang jelas mengenai tujuan, langkah-langkah, dan hasil yang diharapkan.

Kontribusi
Kontribusi untuk meningkatkan cakupan pengujian atau menambahkan teknik pengujian baru sangat disambut. Silakan buat pull request atau buka issue untuk diskusi.
Lisensi
MIT License
