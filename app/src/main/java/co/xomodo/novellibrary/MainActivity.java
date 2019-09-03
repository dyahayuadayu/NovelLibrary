package co.xomodo.novellibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Novel> mNovelList;

    private RecyclerView mRecyclerView;
    private ListNovelAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton buttonNavigation = findViewById(R.id.about);

        createNovelList();
        buildRecyclerView();

        buttonNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.rv_novel);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ListNovelAdapter(mNovelList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ListNovelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, NovelDetail.class);
                intent.putExtra("Paket NovelDetail", mNovelList.get(position));

                startActivity(intent);
            }
        });
    }

    public void createNovelList() {
        mNovelList = new ArrayList<>();
        mNovelList.add(new Novel(R.drawable.omen_1, "OMEN", "Lexie Xu",
                "File 1 : Kasus Penusukan Siswa-Siswi SMA Harapan Nusantara",
                "Tertuduh : Erika Guruh, dikenal juga dengan julukan si Omen. Berhubung tertuduh memang punya tampang seram, sifat nyolot, reputasi jelek penuh cela, tidak ada yang ragu bahwa dia pelakunya. Tambahan lagi, ditemukan bukti-bukti yang mengarah padanya.",
                "Fakta-fakta : Bukan rahasia lagi tertuduh saling membenci dengan korban pertama. Perselisihan antara keduanya semakin menajam saat timbul spekulasi bahwa tertuduh ingin merebut pacar korban pertama. Tidak heran saat korban ditemukan nyaris tewas di proyek pembangunan, kecurigaan langsung tertuju pada tertuduh. Menambah sulit masalah, saat disuruh mendekam di rumah oleh pihak kepolisian, tertuduh malah kabur dengan tukang ojek langganannya yang bertampang residivis. Dan yang pada akhirnya membuat tertuduh terpojok, dia juga orang pertama yang tiba di TKP korban-korban berikutnya.",
                "Misi : Membuktikan tertuduh tidak bersalah dan menemukan pelaku kejahatan yang sebenarnya."));
        mNovelList.add(new Novel(R.drawable.omen_2, "Tujuh Lukisan Horror", "Lexie Xu",
                "File 2 :  Kasus lenyapnya sejumlah orang secara misterius di SMA Harapan Nusantara",
                "Tertuduh : Algojo bertampang monster dan bersenjata parang yang mengerikan, yang konon keluar dari Tujuh Lukisan Horor karya Rima Hujan. Gosipnya, dia berniat menjatuhkan hukuman kepada orang-orang yang terlibat dalam tragedi tahun lalu. Tidak diketahui apakah tokoh ini nyata atau hasil imajinasi.",
                "Fakta-fakta : Sebuah surat ancaman dilayangkan ke Kepala Sekolah SMA Harapan Nusantara, menyebabkan kami dilibatkan dalam peristiwa ini. Dengan bantuan mantan tukang ojek bermuka masam dan montir baik hati garis miring bos geng motor, kami pun mengadakan berbagai penyelidikan mengenai tragedi tahun lalu. Namun, satu demi satu orang yang terlibat dalam kejadian ini mulai lenyap. Yang tertinggal hanyalah ruangan berantakan akibat pergulatan dan lukisan yang menggambarkan hukuman mengerikan yang diterima oleh orang-orang tersebut. Tidak diketahui orang-orang ini masih hidup atau tidak.",
                "Misi : Menemukan orang-orang yang lenyap dan menyelamatkan mereka sekaligus membekuk pelaku kejahatan yang sebenarnya."));
        mNovelList.add(new Novel(R.drawable.omen_3, "Organisasi Rahasia The Judges", "Lexie Xu",
                "File 3 : Kasus penganiayaan murid-murid SMA Harapan Nusantara dalam proses seleksi anggota organisasi rahasia “The Judges”",
                "Tertuduh : Penyelenggara proses seleksi itu, alias para anggota “The Judges” yang semuanya misterius, mencurigakan, dan menyebalkan. Sifat sok berkuasa mereka membuat mereka jadi tertuduh ideal. Belum lagi undangan demi undangan yang dilayangkan pada para anggota kendati sudah terjadi peristiwa-peristiwa tak mengenakkan, menandakan mereka tidak peduli pada korban. Tentu saja, tertuduh utama adalah pemimpin organisasi sok keren ini, si Hakim Tertinggi.",
                "Fakta-fakta : Pada minggu terakhir tahun ajaran, surat-surat undangan dilayangkan pada anak-anak paling cerdas dan berbakat di kelas X, mengajak kami untuk mengikuti proses seleksi untuk menjadi anggota organisasi paling berpengaruh di sekolah kami. Tidak dinyana, satu per satu kami diserang secara brutal pada proses seleksi, ditinggalkan dalam posisi seolah-olah mereka menjadi korban ritual sebuah upacara.",
                "Misi : Menemukan pelaku kejahatan sebelum kami sendiri menjadi korban."));
        mNovelList.add(new Novel(R.drawable.omen_4, "Malam Karnaval Berdarah", "Lexie Xu",
                "File 4 : Kasus perusakan wajah anggota OSIS SMA Harapan Nusantara di malam karnaval",
                "Tertuduh : Kelompok Radikal Anti-Judges. Tidak diketahui siapa sebenarnya anggota kelompok yang namanya jelek banget ini, meski kami punya dugaan kuat: Erika Guruh dan Valeria Guntur, dua anggota The Judges yang membelot lantaran tidak menyetujui kebijakan-kebijakan OSIS. Tambahan lagi, mereka berdua adalah kombinasi paling mematikan di sekolah kami yang sanggup melawan Putri Badai si Hakim Tertinggi, yang punya sekutu berupa ketua OSIS yang punya kemampuan misterius dan wakilnya yang berandalan, alias kami berdua.",
                "Fakta-fakta : Putri Badai menerima surat-surat ancaman untuk membubarkan susunan keanggotaan OSIS dengan tuduhan pemungutan suaranya dimanipulasi. Saat Putri menolak menanggapi mereka, kami menemukan mayat binatang diletakkan di ruang OSIS. Lebih parahnya lagi, di acara pertama yang dilakukan oleh OSIS, mereka mulai mengincar anggota-anggota OSIS yang populer. Satu per satu ditemukan dalam kondisi pingsan, dengan tubuh penuh luka dan wajah yang dirusak.",
                "Misi : Menemukan pelaku sebenarnya sebelum persahabatan kami hancur untuk selamanya."));
        mNovelList.add(new Novel(R.drawable.omen_5, "Kutukan Hantu Opera", "Lexie Xu",
                "File 5 : Kasus Penganiayaan Anak-anak Pelaku Kejahatan SMA Harapan Nusantara Pada Malam Pementasan Kutukan Hantu Opera",
                "Tertuduh : Lagi-lagi Kelompok Radikal Anti-Judges. Kali ini, muncul seseorang yang belum apa-apa sudah berani mati mengakui dirinya sebagai lawan kami. Damian Erlangga, anak baru misterius yang dipenuhi berbagai gosip brutal yang bikin dirinya ditakuti semua orang. Sepertinya dia menaruh minat pada Putri Badai. Mungkin naksir. Selain itu, kami juga harus memperhitungkan Nikki dengan senyum-mulut-robek-nya yang menghantui mimpi buruk kami, serta seseorang yang muncul dari masa lalu Erika.",
                "Fakta-fakta : Diadakan pementasan Phantom of the Opera kendati sudah ada legenda mengenai kutukan Hantu Opera. Gosipnya, saat drama itu dipentaskan, akan ada banyak orang yang mati. Pada saat latihan drama, Aya nyaris saja mengalami kecelakaan yang mengancam nyawanya. Selain itu, masih ada banyak gangguan lain (dicurigai beberapa di antaranya bukan ulah iseng Erika). Kemudian, pada malam pementasan drama, satu per satu orang yang pernah melakukan kejahatan di SMA Harapan Nusantara ditemukan dalam kondisi kritis dan topeng terbelah. Lebih celakanya lagi, di tengah-tengah drama, Valeria hilang.",
                "Misi : Menemukan Valeria dan membekuk pelaku kutukan Hantu Opera."));
        mNovelList.add(new Novel(R.drawable.omen_6, "Sang Penghianat", "Lexie Xu",
                "File 6 : Kasus Penjahit Manusia dengan Korban Atlet-Atlet Unggulan Pekan Olahraga",
                "Tertuduh : Kami. Yep, kalian tidak salah baca. Kami-kami yang seharusnya menyelidiki kasus ini malah menjadi tertuduh lantaran ada beberapa saksi yang mengatakan mereka melihat kami di tempat kejadian. Tentu saja kami tidak sudi pasrah dengan situasi ini dan bertekad untuk menyelidikinya. Kecurigaan kami jatuh pada dua cewek paling jahat di sekolah kami: Nikki dan Eliza. Tambahan lagi, kini mereka mendapat bantuan dari Damian Erlangga sang pangeran iblis, serta mantan sobat kami yang kini menjadi musuh bebuyutan kami: Erika Guruh.",
                "Fakta-fakta : Pada hari-hari menjelang Pekan Olahraga, atlet badminton unggulan sekolah kami ditemukan di lapangan badminton dalam kondisi tidak sadar dengan mata, mulut, dan anggota badan terjahit rapat. Saksi mata berupa sahabat korban mengatakan dia melihat Rima berkeliaran di dekat lapangan pada saat kejadian. Di siang hari, pada hari yang sama, kapten tim futsal ditemukan mengalami kejadian tragis yang sama, dan kali ini orang-orang melihat Putri Badai melarikan diri dari tempat kejadian. Keesokan harinya ada “tips tepercaya” yang mengatakan Aya akan melakukan kejahatan berikutnya, dan sebelum kami sempat melakukan sesuatu Aya sudah ditahan polisi.",
                "Misi : Menemukan pelaku sebenarnya sebelum kami dihukum untuk perbuatan yang tidak kami lakukan."));
        mNovelList.add(new Novel(R.drawable.omen_7, "Target Terakhir", "Lexie Xu",
                "File 7 : Kasus Pelenyapan Anggota-Anggota The Judges",
                "Tertuduh : Siapa lagi kalau bukan Nikki si cewek bermulut nyaris sobek dan ibu angkatnya yang psikopat? Kali ini mereka juga mengajak serta satu oknum lain, yaitu Arman, pacar baru Nikki yang rupanya tidak kalah jahatnya dibanding Nikki. Selain itu, lagi-lagi mereka membawa geng motor Rapid Fire yang tinggal separuhnya setelah sebagian besar dikirim ke rumah sakit oleh si Obeng… maksudku, Les.",
                "Fakta-fakta : Gara-gara terlalu nafsu mengalahkan kami di Pekan Olahraga, tahu-tahu saja Nikki mendapatkan dirinya mendapat beasiswa dan akan dikirim ke luar negeri dalam waktu singkat. Jadilah mereka mulai melakukan aksi-aksi gila, seperti menculik si Obeng dan menyiksanya habis-habisan, menjebak Rima, dan meledakkan rumah Daniel. Supaya tidak melibatkan lebih banyak orang lagi, ayah Val memerintahkan pembubaran The Judges. Sesuai dugaan, kemarahan Nikki dan ibunya tercurah pada kami, para anggota The Judges. Namun tidak disangka, satu per satu teman kami mulai lenyap. Ini adalah endgame Nikki dan ibunya, yang berarti, kemungkinan besar teman-teman kami tidak bakalan kembali hidup-hidup.",
                "Misi kami : Menyelamatkan teman-teman kami sebelum semuanya tewas dibunuh Nikki dan ibunya."));
        mNovelList.add(new Novel(R.drawable.sunset_bersama_rosie, "Sunset Bersama Rosie", "Tere Liye",
                "Resensi Novel Sunset Bersama Rosie",
                "Sunset Bersama Rosie bercerita tentang makna kehilangan, pengorbanan, dan kesempatan. Pada novel ini ada seseorang yang bernama Tegar Karang yang selama 22 tahun hidupnya, ia habiskan bersama sahabatnya Rosie. Rosie yang sudah dianggap sebagai sahabat juga keluarga bagi Tegar, ia menghabiskan seluruh masa muda nya bersama Rosie. Hingga pada akhirnya Tegar memiliki sebuah perasaan kepada Rosie. Tapi tegar tidak berani untuk menyatakan perasaannya kepada Rosie. Hingga pada akhirnya Tegar mengenalkan temannya yang bernama Nathan yang berniatan agar dapat menjadi penghilang kecanggungan saat ia gagal mendapatkan hati Rosie. Tetapi perkenalan mereka akhirnya membuahkan sebuah perasaan antara Rosie dan Nathan. Setelah dua bulan mengenal satu sama lain Rosie dan Nathan pun akhirnya berjadian. Mendengar bahwa Rosie dan Nathan menjadi sepasang kekasih Tegar yang patah hatipun memutuskan menghilang dari kehidupan dua orang sahabat yang cukup berarti dalam hidupnya. Kemudian Ia memutuskan untuk menyibukan diri dalam kesibukan dunia pekerjaan, selama lima tahun ia terus berusaha berdamai dengan masa lalunya. Bekerja tanpa kenal lelah dan tidur, seperti robot yang seolah tidak bisa berhenti. Rosie dan Nathan memiliki empat anak yang bernama Anggrek, Sakura, Jasmine, dan Lili. Siang itu, Rosie dan Nathan datang ke apartemen Tegar ditemani bersama kedua anakmereka, Anggrek dan Sakura.",
                "Maka dimulailah awal semua konflik dalam novel ini. Tegar terus menjalin hubungan dengan keluarga kecil bahagia Rosie, Ia mendapat panggilan “om, uncle, paman Tegar yang Super” dari setiap anak Rosie. Sampai pada hari dimana peristiwa pengeboman di Jimbaran itu terjadi dan seketika merenggut seluruh kebahagiaan yang sebelumnya terpampang jelas wajah mereka. Nathan meninggal dan di situlah muncul benih harapan dalam diri Tegar mengenai kesempatannya terhadap Rosie. Rosie depresi, anak-anak nya terlantar, bisnis keluarga berantakan. Hal itu lah yang membuat Tegar memutuskan untuk membatalkan pertunangannya dengan Sekar, wanita yang sempat dicintainya setelah Rosie, walau dengan pengertian dan pemahaman cinta yang berbeda. Tegar memutuskan untuk memasukan Rosie yang depresi kedalam rehabilitasi dan melanjutkan usaha resort keluarga Nathan. Sejalan dengan itu hubungannya dengan Sekar pun kian merenggang. Sekar pun sukses pergi dari kehidupan Tegar.",
                "Sampai akhirnya dimana Rosie kembali dari rehabilitasi, memunculkan kesempatan yang dulu hilang, kesempatan yang dulu sempat ia bayangkan."));
        mNovelList.add(new Novel(R.drawable.raksasa_dari_jogja, "Raksasa Dari Jogja", "Dwitasari",
                "Resensi Novel Raksasa dari Jogja",
                "Bian (Karina Salim) putri tunggal dari seorang politisi sukses (Ray Sahetapy). Dari luar, hidup Bian terlihat sempurna, walau pun sesungguhnya menyimpan kepedihan melihat ibunya yang hanya lulusan SMA bertahan dari KDRT demi kebahagiaan putri  semata wayangnya. Bian pun memiliki sahabat sejak kecil, Letisha (Adinda Thomas) yang mendukungnya, namun  semua berubah ketika Letisha berselingkuh dengan pacarnya Pras (Kiki Farel). Ditambah lagi Bian harus menghadapi tekanan dari Ayahnya, yang mengatur di mana Bian harus kuliah karena berpengaruh pada portofolio ayahnya.",
                "Bagi Bian, semua yang ada di Jakarta ini sudah cukup, walau pun sebuah peristiwa di halte TransJakarta ketika berebut masuk bis, Bian sempat tersentuh hatinya oleh kelembutan pria bertubuh raksasa (Gabriel) yang menyelamatkannya. Bian akhirnya berkuliah di Yogyakarta dan tinggal bersama Bude (Dewi Irawan) dan putranya, Kevin (Ridwan Ghany).",
                "Puncaknya ketika Kevin berbekal rekaman video handphone, menuduh Gabriel sebagai tukang main perempuan seperti Papa, tepat di saat datang kabar kalau Mama masuk rumah sakit karena Papa. Luka masa lalu Bian pun kembali terbuka. Apakah Bian akan memperjuangkan cinta mereka, atau membiarkannya sirna dan hilang begitu saja?"));
        mNovelList.add(new Novel(R.drawable.hujan, "HUJAN", "Tere Liye",
                "Resensi Novel HUJAN",
                "Novel ini secara mengejutkan menceritakan latar dunia pada tahun 2050-an. Terdapat seorang gadis bernama Lail yang hidup pada masa itu dengan segala kemajuan tekonologinya dan gentingnya isu-isu mengenai lingkungan. Lail berusaha untuk menghapus seluruh kenangannya yang menyakitkan dengan sebuah alat canggih yang ada di zaman tersebut. Syarat agar alat tersebut bisa bekerja adalah dengan menceritakan kenangan-kenganan selama hidupnya tanpa ada satu pun yang ditutup-tutupi.",
                "Lail kemudian bercerita dimulai dari masa kecilnya. Saat itu Lail terburu-buru saat hari pertama masuk sekolah. Bersama ibutnya, ia tidak henti-hentinya menyuruh untuk bergegas supaya tidak ketinggalan kereta. Namun saat perjalanan di kereta, gempa bumi dahsyat terjadi dan mengguncang kota mereka. Semuanya hancur berantakan dan banyak korban berjatuhan termasuk Ibunya Lail. Beruntung Lail selamat karena ditolong oleh seorang anak laki-laki yang memegang tangannya saat akan jatuh ke lorong kereta. Anak laki-laki tersebut bernama Esok.",
                "Tidak hanya sampai disitu. Lail merasa makin menderita setelah mendengar kabar bahwa pulau tempat ayahnya bekerja hancur diterjang tsunami. Lail pun menjadi seorang anak yatim piatu. Setelah kejadian bencana tersebut, Lail tinggal di tempat pengungsian yang dibuat oleh pemerintah kota. Di tempat pengungsian ini, Lail selalu bersama dengan Esok hingga muncul persahabatan di antara mereka dan kelak akan berubah menjadi sebuah cinta."));
        mNovelList.add(new Novel(R.drawable.bg_putih_polos, "", "",
                "",
                "",
                "",
                ""));
    }
}