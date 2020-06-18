package com.example.mobileappc3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarvingActivity extends AppCompatActivity {
    private ArrayList<Carving> mCarving = new ArrayList<>();
    private CarvingAdapter mCarvingAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carving);
        loadCarvings();
        buildRecyclerView();
    }

    private void loadCarvings() {
        //Loads Carvings Database
        //Name, Eng_Name, Description, ImageName
        mCarving.add(new Carving("Waka Maumahara (Memorial Pillar)", "On the ic_nav_icon_marae ātea (courtyard) is 7.5 metre pou (pillar) in the form of a waka (canoe).\r\nThis is the waka maumahara (memorial pillar) which faces Taupiri mountain. At the top of the waka maumahara stands the native kaahu (hawk) representing the Māori Queen Dame Te Atarirangikaahu.\r\n \r\nBelow this are five niho taniwha, a pattern representing the five Māori kings.\r\n- Pōtatau\r\n- Tāwhiao\r\n- Mahuta \r\n- Te Rata \r\n- Korokī. \r\n \r\nLearning and knowledge are symbolised with manaia and matakupenga patterns through the centre, with the pūhoro design representing the Waikato River.", R.drawable.memorial_pillar));
        mCarving.add(new Carving("Pou Whakarae (Pillars)", "Near the waka maumahara (memorial pillar ) are seven smaller pou whakarae(pillars) which symbolise the star cluster Matariki (Pleides).\r\nThis star cluster is significant to Māori and Tainui culture.", R.drawable.pillars));
        mCarving.add(new Carving("Pou-tūā-rangi (Internal Wharenui Post)", "The pou-tūā-rangi (internal wharenui post) near the entrance represents Wintec values.\r\n- Mahi tahi - Working together\r\n- Whakaaro whanui - Challenge and innovation\r\n- Manaaki tangata - Customer focus\r\n- Kia Tika - Taking ownership\r\n- Kia tupu, kia hua - Improvement and opportunity\r\n- Whakamana i te tangata - Valuing people\r\n \r\nIt has been carved in totara from a tree which used to stand on Wintec city campus. Behind the pou-tua-rangi is a tukutuku panel from the original Wintec wharenui, Te Kākano a te Kaahu.", R.drawable.internal_wharenui_post));
        mCarving.add(new Carving("Pou-tūā-rongo - Tawhaki (Internal Wharenui Post)", "Located on the back wall of the wharenui the pou-tūā-rongo is a carving of Tawhaki who received the baskets of knowledge (nga kete wananga).\r\n \r\nTawhaki is featured looking towards the doorway and the world of light. This was also carved in totara from a tree which use to stand on Wintec’s city campus.", R.drawable.internal_wharenui_post_tawhaki));
        mCarving.add(new Carving("Tomokanga (Gateway Entrance)", "The entrance designs welcome people from around the world of Wintec.\r\n \r\nThe sub-tribes (hapū) of this area are shown welcoming visitors onto the ic_nav_icon_marae in a central carving at the entrance.\r\n \r\n Mātauranga Māori and part of the creation story of Tainui are also represented in the carvings.", R.drawable.gateway_entrance));
        mCarving.add(new Carving("Pare and Whakawae (Doorway Lintels)", "Above the wharenui pare (doorway) are three figures nga kete wānanga representing the three baskets of knowledge. Part of the creation story of Tainui is also told in the designs.\r\n \r\nManaia and takarangi patterns symbolise growth and development. The textured ngao matariki pattern on the sides of the doorway (whakawae) represents the welcoming of the cultures and peoples of the world.", R.drawable.doorway_lintel));
        mCarving.add(new Carving("Kōrupe (Window Lintels)", "The taniwha Tuheitia is carved on the window lintel (kōrupe) above the front window of Te Kākano a te Kaahu, along with ngao matariki and manaia designs.\r\n \r\nTuheitia holds guardianship of the Waipa river and was regarded with awe and respect.", R.drawable.window_lintel));
    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView_carving);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mCarvingAdapter = new CarvingAdapter(mCarving);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mCarvingAdapter);
        mCarvingAdapter.setOnItemClickListener(new CarvingAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(CarvingActivity.this, CarvingActivity_Info.class);
                intent.putExtra("carving_item", mCarving.get(position));
                startActivity(intent);
            }
        });
    }
}