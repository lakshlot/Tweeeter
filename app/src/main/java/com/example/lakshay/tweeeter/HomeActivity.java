package com.example.lakshay.tweeeter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.twitter.sdk.android.Twitter;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager mViewPager;
    SectionsPagerAdapter mSectionsPagerAdapter;
    LinearLayout navheaderbackground;
    String banner_url;
    String profilepicture_url;
    CircleImageView navprofilpic;
    TextView navname;
    TextView navscreename;
    Toolbar toolbar;
    CircleImageView toolbapic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         toolbar = (Toolbar) findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbapic=(CircleImageView)findViewById(R.id.userprofilelogo) ;


       


//Fab
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
//navview
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fetchnavcontent();



//sectionadapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        //viewpager
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.tweeetterlogo);
        tabLayout.getTabAt(1).setIcon(R.drawable.following);
        tabLayout.getTabAt(2).setIcon(R.drawable.followers);







    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_profile) {

            // Handle the camera action
            Intent intent=new Intent(this,User_Profile_Activity.class);
            startActivity(intent);
        } else if (id == R.id.my_followers) {

        } else if (id == R.id.my_friends) {

        }  else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main3, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           switch (position){
               case 0:
                   HometimelineFragment hometimelineFragment=new HometimelineFragment();
                   getSupportFragmentManager().beginTransaction().replace(R.id.container,hometimelineFragment).commit();

                   return hometimelineFragment;
               case 1:
                   return PlaceholderFragment.newInstance(position + 1);

               case 2:
                   return PlaceholderFragment.newInstance(position + 1);
               default: return null;


           }



            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return null;
                case 1:
                    return null;
                case 2:
                    return null;
            }
            return null;
        }
    }
    public  void fetchnavcontent() {
        HashMap<String,String> query=new HashMap<>();
        query.put("screen_name",Twitter.getSessionManager().getActiveSession().getUserName());

        GetauthHeader getauthHeader= new GetauthHeader();
        getauthHeader.setBaseurl("https://api.twitter.com/1.1/users/show.json");
        getauthHeader.setQuery(query);

        String header= getauthHeader.returnheader();

        final ApiInterface apiInterface = ApiClient.getAuthorizedApiInterface();



        apiInterface.getUsers(header, Twitter.getSessionManager().getActiveSession().getUserName())
                .enqueue(new Callback<User_Profile>() {
                    @Override
                    public void onResponse(Call<User_Profile> call, Response<User_Profile> response) {
                        Log.i("responsehome",response.body()+"");
                        Log.i("responsetest",response.body().getName());
                        navname=(TextView)findViewById(R.id.nav_user_name_bannertext);
                        navscreename=(TextView)findViewById(R.id.nav_screen_name_bannertext);


                        navheaderbackground=(LinearLayout)findViewById(R.id.nav_header_bannerview);
                        navprofilpic=(CircleImageView) findViewById(R.id.nav_header_profilepicview);

                        navname.setText(response.body().getName());
                        navscreename.setText(response.body().getScreen_name());



                        //Assigning urls
                        banner_url=response.body().getProfile_banner_url();
                        profilepicture_url=response.body().getProfile_image_url();






                        //Assigning ImageViews
                        Picasso.with(HomeActivity.this).load(profilepicture_url).into(navprofilpic);
                        Picasso.with(HomeActivity.this).load(profilepicture_url).into(toolbapic);

                        Picasso.with(HomeActivity.this).load(banner_url).into(new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                navheaderbackground.setBackground(new BitmapDrawable(bitmap));



                            }

                            @Override
                            public void onBitmapFailed(Drawable errorDrawable) {

                            }

                            @Override
                            public void onPrepareLoad(Drawable placeHolderDrawable) {

                            }
                        });













                    }

                    @Override
                    public void onFailure(Call<User_Profile> call, Throwable t) {
                        Log.i("Bodyonfailure",t.getMessage());

                    }
                });






    }






}
