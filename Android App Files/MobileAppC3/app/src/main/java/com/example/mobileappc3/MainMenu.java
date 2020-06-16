package com.example.mobileappc3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {
    private ArrayList<Waiata> mWaiata = new ArrayList<>();
    private ArrayList<Carving> mCarving = new ArrayList<>();

    Fragment waiataFragment = new WaiataFragment();
    Fragment maraeFragment = new MaraeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        loadWaiata();
        loadCarvings();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_menu_fragmentBox, waiataFragment).commit();

    }

    private void loadWaiata() {
        //Loads Waiata Database
        //Name, Desc, Maori_Lyrics, Eng_Lyrics, VideoName
        Waiata w1 = new Waiata("E Kore Koe E Ngaro", "This waiata was composed by members of local kapahaka Te Iti Kahurangi, as a tribute to the ongoing support the group has received from Wintec over the years.\r\n \r\nIt references names and stories associated with our ic_nav_icon_marae, including the wharenui ‘Te Kākano a te Kaahu’, the interior carving ‘Tāwhaki’, the large memorial pillar dedicated to the late Māori Queen “Te Atairangikaahu’, and the three buildings which represent ‘Ngā Kete Wānanga’, the three baskets of knowledge.\r\n \r\nWhen performing this waiata, the last line ‘E ko Te Kuratini o Waikato’ may also be sung at the beginning as an intro and repeated at the end.", "E ko Te Kuratini o Waikato e\r\n \r\nE kore koe e ngaro he kākano i ruia\r\nKākano a te Kaahu e tū nei e\r\nTe kōpū Mānia, te ngāwhā whakatupu\r\nKa tupu he tangata, rere ki te ao\r\n \r\nHorahia Matariki, kūmea ngā waka\r\nHerea ki te pou o te aroha e\r\nTe Atairangikaahu, tāiri kei runga\r\nKo Kīngi Tūheitia ki te whenua e\r\n \r\nPiki ake Tāwhaki, tāhūhū matapū\r\nNgā kete wānanga e toru e\r\nWhītikitia rā, ka turuturu iho\r\nE ko Te Kuratini o Waikato e", "The Waikato Institute of Technology\r\n \r\nYou are not lost, seed of heaven\r\nKākano a te kāhu stand tall\r\nTe kōpū Mānia, cultivate new growth\r\nFoster this person of the world\r\n \r\nMatariki on display, draw in all canoes\r\nBind them to the posts of support and care\r\nTe Atairangikaahu, fly above\r\nKingi Tūheitia, hold steadfast below\r\n \r\nTāwhaki ascend, prepare the house\r\nFor the three baskets of knowledge\r\nBind them, fasten them\r\nTo Waikato Institute of Technology", "");
        mWaiata.add(w1);
        Waiata w2 = new Waiata("He Maimai Aroha nā Tāwhiao", "After the devastation of the Waikato raupatu of land confiscations of 1863, King Tāwhiao sought refuge in Maniapoto or the King Country. After nearly two decades, in the early 1880s he made an emotional return to Waikato.\r\n \r\nThe lament expresses his deeply felt sorrow for the land and its meaning to him. It includes in the lyrics the name of our ic_nav_icon_marae, To kōpū Mānia o Kirikiriroa.", "Ka Mātakitaki iho au ki tr riu o Waikato\r\nAnō nei hei kapo kau ake māku\r\nKi te kapu o taku ringa,\r\nKa whakamiri noa I tōna aratau,\r\nE tia nei he tupu pua hou.\r\n \r\nKia hiwa au I te tihi o Pirongia,\r\nInā hei toronga whakaruruhau mōna\r\nKi tōku tauawhirotanga.\r\n \r\nAnā! Te ngoto o tōna ngāwhā\r\nI ōna uma kīhai I ārikarika\r\nA Maungatautari, a Maungakawa,\r\nōku puke maunga, ngā taonga tuku iho\r\nHoki ake nei au ki tōku awa koiora\r\nMe ōna pikonga He kura tangihihia o te mātāmuri.\r\n \r\nE whakawhiti atu ai I te kōpū mania\r\nO Kirikiriroa\r\nMe ōna māra kai, te ngāwhā whakatupu\r\nAke o te whenua mōmona,\r\nHei kawe ki Ngāruawāhia,\r\nTe huinga o te tangata.\r\nArā, te par haumoko, hei okiokinga mō\r\nTaku upoko\r\nHei tirohanga atu mā raro I ngā hūhā\r\nO Taupiri.\r\n \r\nKei reira rā, kei te oroko hanganga o te\r\nTangata\r\nWāhia te tungaroa o te whare,\r\nte whakaputanga mō te kīngi.", "I look down on the valley of Waikato,\r\nAs though to hold it in the hollow of my hand\r\nAnd caress its beauty\r\nLike some tender verdant thing.\r\n \r\nI reach out from the top of Pirongia\r\nAs though to cover and protect its\r\nsubstance with my own.\r\n \r\nSee how it bursts through the full bosoms\r\nof Maungatautari and Maungakawa,\r\nhills of my inheritance\r\nthe river of life, each curve more beautiful\r\nthan the last.\r\n \r\nCrossing the smooth belly of Kirikiriroa,\r\nits gardens bursting with fullness of the rich\r\nearth towards the meeting place at\r\nNgāruawāhia.\r\n \r\nThere on the fertile mound I would rest\r\nmy head\r\nand look through the thighs of\r\nTaupiri\r\nThere at the place of all creation\r\nlet the king come forth.", "");
        mWaiata.add(w2);
        Waiata w3 = new Waiata("Waikato Te Awa", "Mr Harrison, the author of this poem, writes that ‘when looking on the different hydro works on the Waikato River, I spent quite a few hours of leisure, marvelling at the greatness of the dams and the lakes formed on this waterway. So, in my spare time I made up this poetry about the Waikato River’.\r\n \r\nThis was published in the historical Te Ao Hou magazine in June 1962, issue 29. Over the years, there have been slight adjustments to the poem to suit the context of todays communities. Wintec only sings the first three verses.", "Waikato te awa\r\nKatohia, katohia\r\nhe wai māu\r\nKatohia he wai māu\r\nKa eke ki Te Pūaha\r\no Waikato te awa\r\nhe piko, he taniwha\r\nhe piko, he taniwha\r\n \r\nKia tūpato rā kei tahuri koe\r\nI ngā au kaha o Waikato\r\nWhakamau tō titiro ki tawhiti rā\r\nKo Taupiri te maunga\r\nPōtatau te tangata\r\nTe mauri o te motu e\r\n \r\nE hoe tō waka ki Ngāruawāhia\r\nTūrangawaewae mō te ao katoa\r\nTe tongi whakamutunga a Matutaera\r\nAuē hoki auē", "Waikato te awa\r\ndip in the water\r\nas it surges at the mouth\r\nWaikato is the river\r\nat every bend there lives\r\na chief.\r\n \r\nBe careful lest you capsize\r\nfor the currents are strong\r\nin the Waikato\r\nFix your gaze on the distance\r\nwhere Taupiri is the mountain\r\nand Pōtatau the man.\r\n \r\nPaddle your canoe to Ngāruawahia\r\nto Tūrangawaewae\r\nthe heart of the kingdom\r\nWhere Matutaera finished his lament\r\nAlas, let me grieve also.", "");
        mWaiata.add(w3);
        Waiata w4 = new Waiata("Tutira ma inga iwi", "Wi Huata wrote this song and taught it to his children whilst on a family gathering to Lake Tutira, north of Napier.\r\n \r\nHe was explaining how the iwi came together here to support each other.\r\n \r\nLater he used this song to promote Moral Rearmament, uniting different cultures.", "Tūtira mai ngā iwi\r\ntātou tātou e\r\nTūtira mai ngā iwi\r\ntātou tātou e\r\nWhaia te maramatanga\r\nMe te aroha, e ngā iwi\r\nKia ko tāpatahi,\r\nkia kotāhi rā.\r\nTātou tātou e.\r\n \r\nTūtira mai ngā iwi\r\ntātou tātou e\r\nTūtira mai ngā iwi\r\ntātou tātou e\r\nWhaia te maramatanga\r\nMe te aroha, e ngā iwi\r\nKia ko tāpatahi,\r\nkia kotāhi rā.\r\nTātou tātou e.\r\n \r\nTātou tātou e.\r\nHi aue hei", "Line up together, people\r\nAll of us, all of us.\r\nStand in rows, people\r\nAll of us, all of us.\r\nseek after knowledge\r\nand love of others everybody\r\nBe really virtuous and stay united.\r\nAll of us, all of us.\r\n \r\nLine up together, people\r\nAll of us, all of us.\r\nstand in rows, people\r\nAll of us, all of us.\r\nSeek after knowledge\r\nAnd love of others everybody\r\nBe really virtuous and stay united.\r\nAll of us, all of us.\r\n \r\nAll of us, all of us.\r\nHi aue hei", "");
        mWaiata.add(w4);
        Waiata w5 = new Waiata("Pupuke Te Hihiri", "Nā Nganehu Turner ngā kupu, nā Tania Oxenham te rangi 2004 Nganehu Turner (Ngāti Maniapoto) held the position of pouako (tutor) of Te Reo Māori and kuia at Wintec for many years.\r\n \r\nThis was one of the songs she dedicated to the Māori students of Wintec, all who helped to see their aspirations fulfilled.", "Piki ake e tama e Hine\r\nI te ahurei o te Kuratini o Waikato\r\nHe mātāpono whakaū kounga\r\nKa whakaata i te angitū\r\npiki ake e tama e hine\r\nI te ahurei o te Kuratini o Waikato\r\nHe mātāpono whakaū kounga\r\nKa whakaata i te angitū.\r\n \r\nPupuke te hihiri\r\nPupuke te mahara\r\nPupuke te wānanga a te Kore\r\nPupuke te hihiri\r\nPupuke te mahara\r\nPupuke te wānanga a te Kore\r\n \r\nNō ngā kete i pikihia e Tāwhaki\r\nHe wairua, he mauri, he mana, he reo\r\nHe māramatanga, he mātauranga\r\nHe iho o te ahurea\r\n \r\nPupuke te hihiri \r\nPupuke te mahara \r\nPupuke te wānanga a te Kore\r\nPupuke te hihiri\r\nPupuke te mahara\r\nPupuke te wānanga a te Kore\r\nA te kore", "Ascend son, daughter\r\nto the pinnacle of Wintec\r\nHold fast to quality principles\r\nthat reflect your successes\r\nAscend son, daughter\r\nto the pinnacle of Wintec\r\nHold fast to quality principles\r\nthat reflect your successes.\r\n \r\nFrom conception the increase\r\nFrom increase the thought\r\nFrom thought the knowledge out of chaos\r\nFrom conception the increase\r\nFrom increase the thought from thought\r\nthe knowledge out of chaos.\r\n \r\nFrom the baskets of knowledge Tāwhaki retrieved\r\ncomes spirit, life-force, power, language,\r\nunderstanding and knowledge\r\nThe isthmus of culture.\r\nFrom conception the increase\r\nFrom increase the thought\r\nFrom thought the knowledge out of chaos\r\nFrom conception the increase\r\nFrom increase the thought from thought\r\nthe knowledge out of chaos.", "");
        mWaiata.add(w5);
        Waiata w6 = new Waiata("I Te Whare Whakapiri", "This waiata was written be past Wintec students who came to Wintec to learn Te Reo Māori.\r\nThe song exposes the effects colonization has had on their lives and encourage Wintec to be a pillar by which they and others following can restore what was lost.\r\nIn this instance, it is the language which is the doorway to their cultural inheritance and wellbeing.", "He Māori, tū tangata\r\n \r\nI te whare whakapiri a Tāne\r\nRoto te Kuratini o Waikato\r\nKa puta ngā mamaetanga\r\nRere iho ko ngā roimata\r\nAuē, te arohanui\r\n \r\nHomai, homai taku Māoritanga\r\nWhāngaihia mai tōku reo tuku iho\r\nHe kaiwhakaoho i tōku wairua\r\n \r\nKua ngaro te korekore\r\nPuāwai ana ko ahau\r\nHe Māori tū tangata", "I am Māori\r\nIn this cultural house\r\nthis is within Waikato Institute of Technology\r\nwe feel the sorrow\r\nThe tears, the flow\r\nand the love.\r\nGive back our cultural inheritance\r\nNurture the development of my language\r\nthat awakens my spirit.\r\nThe nothingness has disappeared\r\nI begin to bloom\r\nI am Māori\r\nI am Māori", "");
        mWaiata.add(w6);
        Waiata w7 = new Waiata("Pua Te Kōwhai", "This waiata is suitable for any occasion and is still used both in and out of Wintec. The song jumps around as it follows the flight path of the Tui.\r\n \r\nHistorically, the hill that Wintec sits on was part of the lands designated ‘mara’ or gardening land, thus, the name Te Kōpū Mānia O Kirikiriroa – The Smooth Belly (fertile lands) of Kirikiriroa (known presently as Hamilton).\r\n \r\nWaikato-Taniui, Ngāti Hauā and Ngāti Wairere are the mana whenua (known affiliated tribes) of this land.", "Pua te kōwhai\r\nNgawhā te kōrari\r\nHe tohu kōanga \r\nTau mai e Tui ki tō kāpunipuni\r\nHonihoni, kohikohi\r\nHei oranga, hei rongoā\r\nPania te kiri ki te kōwhai kura\r\nE Tui haurangi i te tākoha o te Atua\r\nRere atu, hoki mai\r\nParea te ua kōwhai\r\nKa whiti mai te rā e", "The kowhai blooms\r\nBursts open in readiness for plucking\r\na sign of spring\r\nThe Tui begin to assemble\r\nTo nibble to gather\r\nFor life and well-being\r\nThe stain of the kowhai touches\r\nWhile Tui get drunk on the nectar of god\r\nFlittering away, returning\r\nA display of yellow\r\nAs the sun shines.", "");
        mWaiata.add(w7);
    }

    private void loadCarvings() {
        //Loads Carvings Database
        //Name, Eng_Name, Description, ImageName
        Carving c1 = new Carving("Waka Maumahara", "Memorial Pillar", "On the ic_nav_icon_marae ātea (courtyard) is 7.5 metre pou (pillar) in the form of a waka (canoe).\r\nThis is the waka maumahara (memorial pillar) which faces Taupiri mountain. At the top of the waka maumahara stands the native kaahu (hawk) representing the Māori Queen Dame Te Atarirangikaahu.\r\n \r\nBelow this are five niho taniwha, a pattern representing the five Māori kings.\r\n- Pōtatau\r\n- Tāwhiao\r\n- Mahuta \r\n- Te Rata \r\n- Korokī. \r\n \r\nLearning and knowledge are symbolised with manaia and matakupenga patterns through the centre, with the pūhoro design representing the Waikato River.", "");
        mCarving.add(c1);
        Carving c2 = new Carving("Pou Whakarae", "Pillars", "Near the waka maumahara (memorial pillar ) are seven smaller pou whakarae(pillars) which symbolise the star cluster Matariki (Pleides).\r\nThis star cluster is significant to Māori and Tainui culture.", "");
        mCarving.add(c2);
        Carving c3 = new Carving("Pou-tūā-rangi", "Internal Wharenui Post", "The pou-tūā-rangi (internal wharenui post) near the entrance represents Wintec values.\r\n- Mahi tahi - Working together\r\n- Whakaaro whanui - Challenge and innovation\r\n- Manaaki tangata - Customer focus\r\n- Kia Tika - Taking ownership\r\n- Kia tupu, kia hua - Improvement and opportunity\r\n- Whakamana i te tangata - Valuing people\r\n \r\nIt has been carved in totara from a tree which used to stand on Wintec city campus. Behind the pou-tua-rangi is a tukutuku panel from the original Wintec wharenui, Te Kākano a te Kaahu.", "");
        mCarving.add(c3);
        Carving c4 = new Carving("Pou-tūā-rongo - Tawhaki", "Internal Wharenui Post", "Located on the back wall of the wharenui the pou-tūā-rongo is a carving of Tawhaki who received the baskets of knowledge (nga kete wananga).\r\n \r\nTawhaki is featured looking towards the doorway and the world of light. This was also carved in totara from a tree which use to stand on Wintec’s city campus.", "");
        mCarving.add(c4);
        Carving c5 = new Carving("Tomokanga", "Gateway Entrance", "The entrance designs welcome people from around the world of Wintec.\r\n \r\nThe sub-tribes (hapū) of this area are shown welcoming visitors onto the ic_nav_icon_marae in a central carving at the entrance.\r\n \r\n Mātauranga Māori and part of the creation story of Tainui are also represented in the carvings.", "");
        mCarving.add(c5);
        Carving c6 = new Carving("Pare and Whakawae", "Doorway Lintels", "Above the wharenui pare (doorway) are three figures nga kete wānanga representing the three baskets of knowledge. Part of the creation story of Tainui is also told in the designs.\r\n \r\nManaia and takarangi patterns symbolise growth and development. The textured ngao matariki pattern on the sides of the doorway (whakawae) represents the welcoming of the cultures and peoples of the world.", "");
        mCarving.add(c6);
        Carving c7 = new Carving("Kōrupe", "Window Lintel", "The taniwha Tuheitia is carved on the window lintel (kōrupe) above the front window of Te Kākano a te Kaahu, along with ngao matariki and manaia designs.\r\n \r\nTuheitia holds guardianship of the Waipa river and was regarded with awe and respect.", "");
        mCarving.add(c7);
    }

    public void btmNavWaiata(MenuItem item) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_menu_fragmentBox, waiataFragment).addToBackStack(null).commit();
    }

    public void btmNavMarae(MenuItem item) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_menu_fragmentBox, maraeFragment).addToBackStack(null).commit();
    }
}