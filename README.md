#
FYI: saya pakai metode mock tabel, dan apabila tidak dengan mock biasanya saya langsung koneksi kan database pada katalon sehingga bisa lakukan checking dengan query seperti ini: 
SELECT 
    b1.id AS booking1_id,
    b2.id AS booking2_id,
    b1.venue_id,
    b1.date,
    b1.start_time,
    b1.end_time
FROM booking b1
JOIN booking b2
    ON b1.venue_id = b2.venue_id
   AND b1.date = b2.date
   AND b1.id < b2.id
   AND (
        (b1.start_time < b2.end_time)
        AND 
        (b2.start_time < b1.end_time)
       );


1. Cara menjalankan tes nya klik dropdown Test Suites > klik Skenario deteksi double booking dan harga dan klik Run, kemudian klik console seperti di gambar ini https://prnt.sc/lJaCfB24CReM
2. https://prnt.sc/6I-uivsFl15F ini adalah menampilkan data yang double booking
