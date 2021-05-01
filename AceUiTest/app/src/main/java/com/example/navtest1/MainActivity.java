package com.example.navtest1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.Chip;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {

    CircleImageView profile_image; //temp
    TextView username; //temp

    FirebaseUser firebaseUser; //temp
    DatabaseReference reference; //temp

    BottomNavigationView bottomNavigation;
    Button editProfile;
    NumberPicker numberPicker;

    Chip chip_one;
    Chip chip_two;
    Chip chip_three;
    Chip chip_four;
    Chip chip_five;
    Chip chip_six;
    Chip chip_seven;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar =findViewById(R.id.toolbar);//temp
        //setSupportActionBar(toolbar);//temp
        //getSupportActionBar().setTitle(""); //temp

        profile_image = findViewById(R.id.profile_image); // temp
        username = findViewById(R.id.username);// temp
        editProfile = findViewById(R.id.homeEdit);


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser(); //temp
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid()); //temp



        /*reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                username.setText(user.getUsername());
                if (user.getImageURL().equals("default")){
                    profile_image.setImageResource(R.mipmap.ic_launcher);
                } else {

                    //change this
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(profile_image);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }); */


        /*TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new ChatsFragment(),"Chats");
        viewPagerAdapter.addFragment(new UsersFragment(), "Users");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager); */




        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("",""));
    }

    /*class ViewPagerAdapter extends FragmentPagerAdapter{ //temp

        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        ViewPagerAdapter (FragmentManager fm){
            super(fm);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }



        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    } */


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;

                        case R.id.navigation_interest:
                            openFragment(InterestFragment.newInstance("", ""));
                            return true;

                        case R.id.navigation_recommendations:
                            openFragment(RecFragment.newInstance("", ""));
                            return true;

                        case R.id.navigation_message:
                            openFragment(MessageFragment.newInstance("",""));
                            return true;
                    }
                    return false;
                }
            };

    public void editProflie(View view) {
        setContentView(R.layout.fragment_editprofile);
    }

    public void editSettings(View view) {
    }

    public void setAge(View view) {
        setContentView(R.layout.set_age);
        numberPicker = findViewById(R.id.numPicker);
        numberPicker.setMinValue(18);
        numberPicker.setMaxValue(100);
    }

    public void setGender(View view) {
        setContentView(R.layout.set_gender);
        chip_one = (Chip)findViewById(R.id.chip1);
        chip_two = (Chip)findViewById(R.id.chip2);
        chip_three = (Chip)findViewById(R.id.chip3);
        chip_four = (Chip)findViewById(R.id.chip4);
        chip_five = (Chip)findViewById(R.id.chip5);
        chip_six = (Chip)findViewById(R.id.chip6);
        chip_seven = (Chip)findViewById(R.id.chip7);
    }

    public void setSexualOrientation(View view) {
    }

    public void setLocation(View view) {
    }

    public void setPoliticalViews(View view) {
    }

    public void setHeight(View view) {
    }

    public void setReligiousViews(View view) {
    }
}