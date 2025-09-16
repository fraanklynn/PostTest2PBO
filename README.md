# PostTest2PBO

## Deskripsi Program
Program ini adalah aplikasi manajemen fasilitas gym berbasis Java dan menerapkan operasi CRUD (Create, Read, Update, Delete). Program ini dibagi menjadi tiga package utama, yaitu models untuk menyimpan struktur data melalui class Fasilitas, service untuk mengatur logika CRUD melalui class FasilitasService, dan main untuk menampilkan menu interaktif sebagai antarmuka pengguna. Dengan adanya program ini, pengguna dapat mengelola data fasilitas gym seperti treadmill, dumbbell, dan peralatan lainnya secara sederhana dan terorganisir.

## Alur Program 
1. Program dimulai dari class Main yang menampilkan menu utama.
2. Pengguna memilih salah satu opsi menu:
- Tambah Fasilitas → Input ID, nama, dan status, lalu data disimpan ke ArrayList.
- Lihat Fasilitas → Menampilkan seluruh data fasilitas yang ada.
- Update Fasilitas → Meminta ID, lalu pengguna memasukkan nama dan status baru untuk memperbarui data.
- Hapus Fasilitas → Meminta ID, jika sesuai maka data akan dihapus dari ArrayList.
- Cari Fasilitas → Pengguna mengetik nama fasilitas, program mencari dan menampilkan hasilnya.
- Keluar → Program berhenti dengan pesan keluar.

3. Semua logika CRUD dijalankan di dalam class FasilitasService.

4. Class Fasilitas hanya digunakan untuk menyimpan atribut dan constructor data fasilitas.
