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

## Struktur Packages
##### <img width="399" height="194" alt="image" src="https://github.com/user-attachments/assets/b6ef6a0f-7839-4ed1-894f-42ec661ab413" />
1.Package models
- Berisi class Fasilitas yang digunakan sebagai model data atau cetakan objek fasilitas gym.
- Menyimpan atribut seperti idFasilitas, namaFasilitas, dan status, serta constructor untuk menginisialisasi objek.
- Fungsi utama package ini adalah menyimpan struktur data yang akan digunakan oleh logika program.
2. Package service
- Berisi class FasilitasService yang berfungsi sebagai pengelola data fasilitas.
- Di sini terdapat logika CRUD: menambah (tambahFasilitas), melihat (lihatFasilitas), memperbarui (updateFasilitas), menghapus (hapusFasilitas), dan mencari fasilitas (cariFasilitas).
- Data fasilitas disimpan sementara dalam ArrayList<Fasilitas>.
- Fungsi utama package ini adalah menangani semua operasi pada data sesuai input dari pengguna.
3. Package com.mycompany.main
- Berisi class Main yang menjadi titik masuk (entry point) program.
- Menampilkan menu interaktif kepada pengguna dan menerima input pilihan.
- Memanggil method-method di FasilitasService sesuai pilihan menu.
- Fungsi utama package ini adalah menghubungkan pengguna dengan logika CRUD yang ada di service

## Penjelasan Code
```
package models;

public class Fasilitas {
    public int idFasilitas;
    public String namaFasilitas;
    public String status;
```

Kode ini mendefinisikan class Fasilitas yang digunakan untuk menyimpan data tentang fasilitas gym. Di dalamnya terdapat tiga atribut, yakni idFasilitas untuk ID unik fasilitas, namaFasilitas untuk nama fasilitas, dan status untuk kondisi fasilitas. Class ini juga memiliki constructor yang berguna untuk membuat objek Fasilitas sekaligus memberikan nilai awal pada atributnya. Jadi secara keseluruhan, class ini berfungsi sebagai cetakan data fasilitas yang akan dipakai di proses CRUD pada FasilitasService.

```
package service;

import models.Fasilitas;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FasilitasService {
    ArrayList<Fasilitas> daftarFasilitas = new ArrayList<>();
```
Kode ini berada di package service, yang berfungsi untuk mengelompokkan class-class yang berisi logika atau layanan (service) dalam aplikasi. Di dalam package ini terdapat class FasilitasService yang berperan sebagai pengelola data fasilitas gym. Class ini memiliki atribut daftarFasilitas berupa ArrayList<Fasilitas>, yang digunakan untuk menyimpan semua objek Fasilitas secara dinamis. Selain itu, class ini nantinya akan menampung semua logika CRUD (Create, Read, Update, Delete), sehingga setiap fasilitas dapat ditambahkan, dilihat, diperbarui, atau dihapus sesuai input dari pengguna. Dengan menggunakan ArrayList, data fasilitas dapat disimpan sementara di memori dan diakses dengan mudah selama program berjalan.

```
public FasilitasService() {
        daftarFasilitas.add(new Fasilitas(1, "Treadmill", "Tersedia"));
        daftarFasilitas.add(new Fasilitas(2, "Dumbbell", "Tersedia"));
    }
```
Kode ini adalah constructor FasilitasService yang berfungsi untuk menginisialisasi objek FasilitasService sekaligus menambahkan beberapa data fasilitas awal, yaitu Treadmill dan Dumbbell, sehingga daftar fasilitas sudah tersedia saat program dijalankan.

```
public void tambahFasilitas(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama Fasilitas: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Status Fasilitas: ");
        String status = scanner.nextLine();

        Fasilitas fasilitas = new Fasilitas(id, nama, status);
        daftarFasilitas.add(fasilitas);
        System.out.println("Fasilitas berhasil ditambahkan!");
```
Method tambahFasilitas(Scanner scanner) digunakan untuk menambahkan fasilitas baru ke dalam daftar fasilitas. Program akan meminta input dari pengguna berupa ID, nama, dan status fasilitas. Setelah data dimasukkan, dibuat objek Fasilitas baru dengan informasi tersebut, lalu ditambahkan ke dalam ArrayList daftarFasilitas. Setelah itu, program menampilkan pesan “Fasilitas berhasil ditambahkan!” sebagai tanda bahwa fasilitas baru sudah tersimpan. Dengan cara ini, pengguna bisa menambahkan fasilitas baru secara fleksibel tanpa mengubah kode program.

```
public void lihatFasilitas() {
        if (daftarFasilitas.isEmpty()) {
            System.out.println("Belum ada fasilitas yang tersimpan.");
        } else {
            System.out.println("\n=== Daftar Fasilitas ===");
            for (Fasilitas f : daftarFasilitas) {
                System.out.println("ID: " + f.idFasilitas + 
                                   " | Nama: " + f.namaFasilitas + 
                                   " | Status: " + f.status);
            }
        }
    }
```
Method lihatFasilitas() digunakan untuk menampilkan seluruh data fasilitas yang tersimpan di daftarFasilitas. Pertama, program memeriksa apakah ArrayList kosong menggunakan isEmpty(). Jika kosong, akan muncul pesan “Belum ada fasilitas yang tersimpan.”. Jika tidak kosong, program menampilkan judul daftar fasilitas, lalu menggunakan perulangan for-each untuk menampilkan setiap fasilitas, lengkap dengan ID, nama, dan statusnya. Method ini memungkinkan pengguna untuk melihat semua fasilitas yang sudah tersimpan secara rapi dan terstruktur.

```
public void updateFasilitas(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas yang ingin diupdate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Fasilitas f : daftarFasilitas) {
            if (f.idFasilitas == id) {
                System.out.print("Masukkan Nama Baru: ");
                f.namaFasilitas = scanner.nextLine();
                System.out.print("Masukkan Status Baru: ");
                f.status = scanner.nextLine();
                System.out.println("Data fasilitas berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Fasilitas dengan ID " + id + " tidak ditemukan.");
```
Method updateFasilitas(Scanner scanner) digunakan untuk memperbarui data fasilitas yang sudah ada. Pertama, program meminta pengguna memasukkan ID fasilitas yang ingin diupdate. Setelah itu, program melakukan perulangan for-each untuk mencari objek Fasilitas di daftarFasilitas yang memiliki ID sama dengan input. Jika ditemukan, program akan meminta pengguna memasukkan nama baru dan status baru, lalu langsung memperbarui atribut namaFasilitas dan status dari objek tersebut. Setelah data diperbarui, program menampilkan pesan “Data fasilitas berhasil diperbarui!” dan keluar dari method. Jika ID yang dimasukkan tidak ditemukan, program menampilkan pesan bahwa fasilitas dengan ID tersebut tidak ada. Method ini memungkinkan pengguna untuk memperbarui informasi fasilitas secara langsung tanpa menghapus dan menambahkan ulang data.

```
public void hapusFasilitas(Scanner scanner) {
        System.out.print("Masukkan ID Fasilitas yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Iterator<Fasilitas> it = daftarFasilitas.iterator();
        while (it.hasNext()) {
            Fasilitas f = it.next();
            if (f.idFasilitas == id) {
                it.remove();
                System.out.println("Fasilitas berhasil dihapus!");
                return;
            }
        }
        System.out.println("Fasilitas dengan ID " + id + " tidak ditemukan.");
    }
```
Method hapusFasilitas(Scanner scanner) digunakan untuk menghapus fasilitas dari daftar. Pertama, program meminta pengguna memasukkan ID fasilitas yang ingin dihapus. Kemudian, program menggunakan Iterator untuk menelusuri daftarFasilitas. Jika ditemukan objek Fasilitas dengan ID yang sama, objek tersebut dihapus menggunakan it.remove(), dan program menampilkan pesan “Fasilitas berhasil dihapus!”. Jika ID tidak ditemukan dalam daftar, program menampilkan pesan bahwa fasilitas dengan ID tersebut tidak ada. Dengan method ini, pengguna bisa menghapus data fasilitas secara aman tanpa menyebabkan error saat perulangan.

```
 public void cariFasilitas(Scanner scanner) {
        System.out.print("Masukkan Nama Fasilitas yang ingin dicari: ");
        String namaCari = scanner.nextLine().trim();
        boolean ditemukan = false;

        for (Fasilitas f : daftarFasilitas) {
            if (f.namaFasilitas.toLowerCase().contains(namaCari.toLowerCase())) {
                System.out.println("Ditemukan: ID: " + f.idFasilitas + 
                                   " | Nama: " + f.namaFasilitas + 
                                   " | Status: " + f.status);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Fasilitas dengan nama '" + namaCari + "' tidak ditemukan.");
```
Method cariFasilitas(Scanner scanner) digunakan untuk mencari fasilitas berdasarkan nama. Program pertama-tama meminta pengguna memasukkan nama fasilitas yang ingin dicari, lalu menyimpannya ke variabel namaCari dan menghapus spasi tambahan dengan trim(). Selanjutnya, program melakukan perulangan for-each untuk memeriksa setiap objek Fasilitas di daftarFasilitas. Jika nama fasilitas mengandung teks yang dicari (diperiksa secara case-insensitive dengan toLowerCase()), program menampilkan detail fasilitas tersebut dan menandai bahwa fasilitas ditemukan. Jika tidak ada fasilitas yang cocok, program menampilkan pesan bahwa fasilitas dengan nama yang dimasukkan tidak ditemukan. Method ini memungkinkan pengguna mencari fasilitas secara fleksibel tanpa harus memasukkan nama persis.


## Penjelasan Output

### <img width="660" height="690" alt="Screenshot 2025-09-16 075814" src="https://github.com/user-attachments/assets/bf5a43d5-d82d-4652-b0ef-1ff355cbeb3a" />
ini adalah output dari menu 1 yaitu tambah fasilitas, disini program meminta memasukkan id dari fasilitas yang ingin ditambahkan, nama fasilitas yang ingin ditambahkan, lalu status dari fasilitas yang ingin ditambahkan jika sudah maka fasilitas berhasil ditambahkan, dan terlihat bahwa fasilitas telah ditambahkan 
### <img width="625" height="352" alt="Screenshot 2025-09-16 075825" src="https://github.com/user-attachments/assets/e8646f69-908f-4f9b-9fa6-5a7bdc36559b" />
ini adalah output dari menu 2 yaitu lihat fasilitas terlihat fasilitas yang ada terdiri dari id,nama fasilitas, dan status fasilitas
### <img width="628" height="665" alt="Screenshot 2025-09-16 075907" src="https://github.com/user-attachments/assets/c06600b1-37b2-4ae8-bd02-36cc86b6ec84" />
ini adalah output dari menu 3 yaitu update fasilitas, disini program meminta memasukkan id dari fasilitas yang ingin diupdate, nama dari id fasilitas yang ingin diupdate, lalu status dari id fasilitas yang ingin diupdate jika sudah maka fasilitas berhasil diupdate, dan terlihat bahwa fasilitas telah diupdate
### <img width="621" height="612" alt="Screenshot 2025-09-16 075925" src="https://github.com/user-attachments/assets/8fbb1693-58a7-49d1-98af-a07f8d7d58a1" />
ini adalah output dari menu 4 yaitu hapus fasilitas, disini program meminta memasukkan id dari fasilitas yang ingin dihapus, jika sudah maka fasilitas berhasil dihapus, dan terlihat bahwa fasilitas telah dihapus
### <img width="788" height="292" alt="Screenshot 2025-09-16 075949" src="https://github.com/user-attachments/assets/d5c44a55-dd8f-46d8-bf4d-12706c372396" />
ini adalah output dari menu 5 yaitu cari fasilitas, disini program meminta memasukkan nama dari fasilitas yang ingin dicari, dan terlihat program menemukan fasilitas yang ingin dicari 
### <img width="1177" height="402" alt="Screenshot 2025-09-16 075958" src="https://github.com/user-attachments/assets/82f6496d-7ba7-4127-85f7-7c2df7f211eb" />
ini adalah output dari menu 6 yaitu keluar, jika memilih menu 6 maka akan keluar dari program




 
