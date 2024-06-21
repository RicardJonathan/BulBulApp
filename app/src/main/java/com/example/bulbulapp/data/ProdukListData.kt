package com.example.bulbulapp.data

import com.example.bulbulapp.R
import com.example.bulbulapp.model.ProdukListItem
import com.example.bulbulapp.model.RekomendasiTokoItem

object ProdukListData {

    val ProdukListItems = listOf(
        ProdukListItem(
            productId = 0,
            productImage = R.drawable.product_whiskas,
            productTags = "Makanan Kering",
            productName = "Whiskas Adult Cat Tuna 1.2 Kg",
            productAbout = "Whiskas makanan kucing yang sehat dan seimbang, secara spesifik di formulasikan untuk memenuhi kebutuhan nutrisi kucing pada setiap masa kehidupannya...",
            productInfo = mapOf(
                "Kisaran Umur" to "1 - 6 tahun",
                "Harga per hidangan" to "Rp. 1.700",
                "Brand" to "Whiskas",
                "Perusahaan Induk" to "Mars Incorporated"
            ),
            productNutritionalContent = mapOf(
                "Lemak (min)" to "9%",
                "Serat (maks)" to "5%",
                "Kadar Air (maks)" to "12%",
                "Kalsium (maks)" to "1.4%",
                "Total Fosfor (maks)" to "1.3%"
            ),
            productIngredients = "Sereal (Jagung dan/atau Gandum), Daging Unggas Olahan, Tepung Bulu Terhidrolisis, Bekatul Tanpa Lemak, Palm Stearin, Tepung Kacang Kedelai, Ikan Terhidrolisis, Tepung Gandum, Mineral, Tepung Jagung Gluten, GaransBeryodium, Vitamin, Taurin, Pewarna, Pengawet, Metionin, Perasa",
            additionalInfo = "Mengandung Omega 3 & 6 dan Zinc untuk kesehatan kulit dan bulu yang indah, Mengandung Vit.A dan taurine untuk kesehatan matanya, Mengandung protein dari ikan yang segar, lemak yang baik, vitamin dan mineral yang seimbang, untuk tetap menjaga kucingmu aktif dan bahagia.",
            recommendations = listOf(
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_shopee,
                    price = 67275,
                    description = "Harga Terbaik",
                    url = "https://shopee.co.id/Whiskas-Adult-Cat-Tuna-Dry-Food-Makanan-Kucing-Kering-1.2kg-i.934857464.22229940166",
                ),
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_tokped,
                    price = 59400,
                    description = "Lebih Murah",
                    url = "https://tokopedia.link/2TboAxy1zKb"
                ),
            )
        ),
        ProdukListItem(
            productId = 1,
            productImage = R.drawable.product_meofish,
            productTags = "Makanan Basah",
            productName = "Me-O 80 Gram Adult Ocean Fish",
            productAbout = "Mengandung nutrisi seimbang dan rasa yang disukai oleh kucing berfungsi untuk mendorong pertumbuhan yang ideal, mengandung Double Plus Formula.",
            productInfo = mapOf(
                "Kisaran Umur" to "3 - 12 bulan",
                "Harga per hidangan" to "Rp. 1.320",
                "Brand" to "me-O fish",
                "Perusahaan Induk" to "Perfect Companion Group"
            ),
            productNutritionalContent = mapOf(
                "Crude Protein" to "30%",
                "Crude Fat" to "12%",
                "Crude Fiber" to "5%",
                "Moisture" to "12%",
            ),
            productIngredients = "Whole grain cereals (corn and rice), poultry meal, vegetable protein (soybean and corn), fish meal, cassava, chicken fat, brewers dried yeast, fish digest, tuna meal, lodized salt, taurine, vitamins and minerals, antioxidants, food coloring.",
            additionalInfo = "Tidak Ada",
            recommendations = listOf(
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_shopee,
                    price = 6350,
                    description = "Harga Terbaik",
                    url = "https://shopee.co.id/Me-O-(80-gram)-i.631874537.11079349942",
                ),
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_tokped,
                    price = 5503,
                    description = "Lebih Murah",
                    url = "https://tokopedia.link/DmJifcq1zKb",
                ),
            )
        ),
        ProdukListItem(
            productId = 2,
            productImage = R.drawable.product_chummy_dog,
            productTags = "Makanan Basah",
            productName = "Chumy Pet Dog Kaleng 375 Gram",
            productAbout = "Makanan anjing yang terbuat dari bahan-bahan berkualitas tinggi dengan harga ekonomis, Cocok untuk semua umur anjing. Memiliki bau yang harum yang disukai semua anjing.",
            productInfo = mapOf(
                "Kisaran Umur" to "1 - 12 bulan",
                "Harga per hidangan" to "Rp. 9.000",
                "Brand" to "Chummy Pets",
                "Perusahaan Induk" to "Perfect Companion Group"
            ),
            productNutritionalContent = mapOf(
                "Protein kasar (max)" to "7%",
                "Lemak kasar (max)" to "5%",
                "Kadar abu (min)" to "2%",
                "Kadar kelembaban (min)" to "82%",
            ),
            productIngredients = "Daging, Pati, Air, Garam, Tidak mengandung bahan pengawet.",
            additionalInfo = "Bisa dikasih secara langsung, dicampur ke Dog food kering ataupun dicampur ke makanan lain. Bila kaleng telah dibuka, segera dihabiskan, maksimal 2-3 hari dalam keadaan terbuka sebaiknya langsung dimasukin ke kulkas untuk menjaga kesegaran produk. Lamanya penyimpanan di kulkas kurang lebih seminggu.",
            recommendations = listOf(
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_shopee,
                    price = 13800,
                    description = "Lebih Murah",
                    url = "https://shopee.co.id/CHUMMY-PET-Beef-Lamb-Dog-Food-Kaleng-375-Gram-Makanan-Anjing-Murah-i.51777094.3762404943",
                ),
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_tokped,
                    price = 15000,
                    description = "Harga Terbaik",
                    url = "https://tokopedia.link/ym5XjVO1zKb",
                ),
            )
        ),
        ProdukListItem(
            productId = 3,
            productImage = R.drawable.product_shampoo,
            productTags = "Shampoo",
            productName = "Olive Care Shampoo Anti Fungal & Fleas",
            productAbout = "Olive Care Anti Fungal & Fleas merupakan salah satu produk shampo olive care yang diformulasikan untuk mengatasi masalah kulit dan bulu pada hewan. Terbuat dari baha-bahan pilihan yang bekerja secara efektif dalam membasmi jamur hingga kutu. Sangat cocok digunakan pada semua jenis kucing yang masih anakan hingga dewasa.",
            productInfo = mapOf(
                "Kisaran Umur" to "0 - 15 tahun",
                "Harga per hidangan" to "-",
                "Brand" to "Olive Care Shampoo Anti Fungal & Fleas",
                "Perusahaan Induk" to "Tidak Ada"
            ),
            productNutritionalContent = mapOf(
                "Bahan Alami Olive" to "100%",
            ),
            productIngredients = "Tidak Ada",
            additionalInfo = "Manfaat Shampo Anti Fungal & Fleas ini: Membasmi serta melindungi dari Jamur & Kutu, Menghilangkan rasa gatal, Bebas dari alergi dan bakteri, Anti inflamasi dan radang kulit, Aman untuk kulit yang sensitif.",
            recommendations = listOf(
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_shopee,
                    price = 57000,
                    description = "Lebih Murah",
                    url = "https://shopee.co.id/OLIVE-CARE-Shampo-Kucing-ANTI-FUNGAL-FLEAS-i.513626901.25576484773?sp_atk=c578443a-2038-4c88-b3b1-377afebeaf74&xptdk=c578443a-2038-4c88-b3b1-377afebeaf74",
                ),
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_tokped,
                    price = 72710,
                    description = "Harga Terbaik",
                    url = "https://tokopedia.link/sIqDKY01zKb",
                ),
            )
        ),
        ProdukListItem(
            productId = 4,
            productImage = R.drawable.product_kalung,
            productTags = "Aksesoris",
            productName = "Dog & Cat Collar - Kalung Wool ",
            productAbout = "Kalung cocok untuk Anjing kesayanganmu.",
            productInfo = mapOf(
                "Kisaran Umur" to "0 - 5 tahun",
                "Harga per hidangan" to "-",
                "Brand" to "No Brand",
                "Perusahaan Induk" to "Tidak Ada"
            ),
            productNutritionalContent = mapOf(
                "Tidak Ada" to " - ",
            ),
            productIngredients = "100% berbahan nilon yang nyaman untuk anabul kesayanganmu.",
            additionalInfo = "Tidak Ada",
            recommendations = listOf(
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_shopee,
                    price = 5180,
                    description = "Lebih Murah",
                    url = "https://shopee.co.id/Kalung-Kucing-Anjing-Cetakan-bintang-Lonceng-Pet-Cat-Collar-Aksesori-Hewan-i.1159110106.28651391199?sp_atk=bbe67953-bff1-4397-9111-3a8d8bd09703&xptdk=bbe67953-bff1-4397-9111-3a8d8bd09703",
                ),
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_tokped,
                    price = 11000,
                    description = "Harga Terbaik",
                    url = "https://tokopedia.link/7v5zCjg2zKb",
                ),
            )
        ),
        ProdukListItem(
            productId = 5,
            productImage = R.drawable.product_vitamin,
            productTags = "Obat & Vitamin",
            productName = "Olive Care Vitamin Kucing Bulu Gembul",
            productAbout = "Olive Care Shampo Kucing Total Protection ANTI FUNGAL & FLEAS untuk Jamur, Kutu, Scabies, Parasit, Alergi dan Radang Kulit.",
            productInfo = mapOf(
                "Kisaran Umur" to "0 - 5 tahun",
                "Harga per hidangan" to " ",
                "Brand" to "Olive Care Vitamin",
                "Perusahaan Induk" to "Tidak Ada"
            ),
            productNutritionalContent = mapOf(
                "Kalsium" to " - ",
                "Zinc   " to " -",
                "Vitamin A" to " - ",
                "Vitamin B" to " - ",
            ),
            productIngredients = "Taurine, Organic Rosemary Extract, Brewers Dried Yeast, Biotin, Natural Mixed Tocopherols, Rice Flour, Vit. A Acetate, Cholecalciferol (vit. D3), Vit. E Supplement, Choline Chloride, D-calcium Pantothenate, Niacin Supplement, Riboflavin Supplement, Pyridoxine Hydrochloride, Thiamine Mononitrate, B12 Supplement, Biotin, Folic Acid, Ascorbic Acid (source of vit. C) Inositol, Para-Aminobenzoic Acid, Ferrous Sulfate, Manganese Sulfate, Zinc Sulfate, Copper Sulfate, Calcium lodate, Cobalt Sulfate,Magnesium O xide, Potassium Chloride , Zinc Methionine Complex, Manganese Complex, Copper Lysine Complex, Cobalt Glucoheptonate, Ferric Methionine Complex, Citric Acid.",
            additionalInfo = "Bahan alami yang SANGAT AMAN untuk dikonsumsi kucing, termasuk kondisi hamil dan menyusui.",
            recommendations = listOf(
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_shopee,
                    price = 52000,
                    description = "Lebih Murah",
                    url = "https://shopee.co.id/Olive-Care-40-Kapsul-Vitamin-Kucing-Bulu-Untuk-Bulu-Panjang-Lebat-Bulu-Halus-Warna-Bulu-Cegah-Jamur-Dan-Bulu-Rontok-i.365632089.23376471090?sp_atk=02d4c4fd-bd28-4108-abc4-64f9e8e522bb&xptdk=02d4c4fd-bd28-4108-abc4-64f9e8e522bb",
                ),
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_tokped,
                    price = 84900,
                    description = "Harga Terbaik",
                    url = "https://tokopedia.link/MND27In2zKb",
                ),
            )
        ),
        ProdukListItem(
            productId = 6,
            productImage = R.drawable.product_catchoize,
            productTags = "Makanan Kering",
            productName = "Cat Choize Adult  Salmon 800 Gram",
            productAbout = "Cat Choize mengandung nutrisi lengkap, vitamin dan mineral yang membuat kucing Anda sehat. Dikembangkan dengan pola diet yang seimbang untuk memastikan pertumbuhan kucing yang optimal. Cat Choize cocok untuk semua jenis kucing dalam setiap tahap perkembangannya.",
            productInfo = mapOf(
                "Kisaran Umur" to "1 - 5 tahun",
                "Harga per hidangan" to "Rp. 8.000",
                "Brand" to "Cat Choize",
                "Perusahaan Induk" to "Perfect Companion Indonesia"
            ),
            productNutritionalContent = mapOf(
                "Crude Protein" to "27%",
                "Crude Fat" to "9%",
                "Crude Fiber" to "4%",
                "Moisture" to "10%"
            ),
            productIngredients = "Mengandung Nutrisi Lengkap, Vitamin dan Mineral, Kesehatan Gigi, Fungsi Pencernaan, Kesehatan Kulit dan Bulu, Penglihatan.",
            additionalInfo = "Tidak Ada",
            recommendations = listOf(
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_shopee,
                    price = 16900,
                    description = "Harga Terbaik",
                    url = "https://shopee.co.id/Cat-Choize-Adult-800gr-makanan-kucing-dewasa-i.29618259.1987961725?sp_atk=99137c4e-1abd-450c-8a11-02e24ad48479&xptdk=99137c4e-1abd-450c-8a11-02e24ad48479",
                ),
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_tokped,
                    price = 16885,
                    description = "Lebih Murah",
                    url = "https://tokopedia.link/iAb1vJy2zKb",
                ),
            )
        ),
        ProdukListItem(
            productId = 7,
            productImage = R.drawable.product_removflu,
            productTags = "Obat & Vitamin",
            productName = "Remov Flu Cat Dog Obat Flu & Pilek",
            productAbout = "REMOV Obat Flu Dan Pilek Kucing Dan Anjing 10ml adalah obat yang efektif mengatasi flu dan pilek pada kucing dan anjing yang di formulasikan khusus menggunakan komposisi yang sangat aman untuk hewan peliharaan anda.",
            productInfo = mapOf(
                "Kisaran Umur" to "0 - 5 tahun",
                "Harga per hidangan" to "Rp. 8.000",
                "Brand" to "Remov Flu Cat Dog",
                "Perusahaan Induk" to " Tidak Ada "
            ),
            productNutritionalContent = mapOf(
                "Acetylcysteine" to "300mg  ",
                "Betamethasone" to "0.25mg",
                "Phenyl Proph" to "12.5mg",
                "Vit C" to "250mg"
            ),
            productIngredients = "ALPINIA GALANGA, AMMONIUM CLORIDA, SUCCUS LIQUIRITIAE, GINGSENG, ZINGIBER ZERUMBET, ECHINACEA, GINGER, FOENICULUM VULGARE.",
            additionalInfo = "Tidak Ada",
            recommendations = listOf(
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_shopee,
                    price = 10800,
                    description = "Lebih Murah",
                    url = "https://shopee.co.id/REMOV-Obat-FLU-Dan-PILEK-Kucing-Dan-Anjing-10ml-obak-pilek-10-ml-i.1143749898.24429873727?sp_atk=ef59a363-ae7b-455c-b149-662bdc16fa23&xptdk=ef59a363-ae7b-455c-b149-662bdc16fa23",
                ),
                RekomendasiTokoItem(
                    logoImage = R.drawable.logo_tokped,
                    price = 14900,
                    description = "Harga Terbaik",
                    url = "https://tokopedia.link/6knYKoD2zKb",
                ),
            )
        ),
    )
}