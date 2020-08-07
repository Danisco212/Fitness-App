package com.example.fitnessapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fitnessapp.Fragments.ArticlesFragment;
import com.example.fitnessapp.Fragments.HomeFragment;
import com.example.fitnessapp.Fragments.TrainersFragment;
import com.example.fitnessapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainAppActivity extends AppCompatActivity {

  // slide menu items
  private DrawerLayout mDrawer;
  private ActionBarDrawerToggle mToggle;
  private NavigationView navigationView;
  private Toolbar toolbar;

  private BottomNavigationView bottomNav;


  private boolean atHome;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_app);

    init();
  }

  private void init(){
    bottomNav = findViewById(R.id.bottomNav);
    navigationView = findViewById(R.id.navView);
    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    mDrawer = findViewById(R.id.drawer);
    mToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.open, R.string.close);

    mDrawer.addDrawerListener(mToggle);
    mToggle.syncState();

    loadHomeFragment();
    bottomNavClicks();

  }

  // loading fragments
  private void loadFragment(Fragment fragment){
    atHome = false;
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();

    try {
      transaction.replace(R.id.fragmentHolder, fragment);
      transaction.commit();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  // setting up the nav click events
//    private void navigationItemClick(){
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.home:
//                        if (!atHome)
//                            loadHomeFragment();
//                        break;
//                    case R.id.articles:
//                        Toast.makeText(MainAppActivity.this, "Articles buttom", Toast.LENGTH_SHORT).show();
//                        loadFragment(new ArticlesFragment());
//                        break;
//                    case R.id.search:
//                        break;
//                    case R.id.trainers:
//                        break;
//                    case R.id.profile:
//                        break;
//
//                }
//                return false;
//            }
//        });
//    }

  // setting up the clicks for the bottom nav bar
  private void bottomNavClicks(){
    bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
          case R.id.home:
            if (!atHome)
              loadHomeFragment();
            break;
          case R.id.articles:
//                        Toast.makeText(MainAppActivity.this, "Articles buttom", Toast.LENGTH_SHORT).show();
            loadFragment(new ArticlesFragment());
            setTitle("Articles");
            break;
          case R.id.search:
            break;
          case R.id.trainers:
            loadFragment(new TrainersFragment());
            setTitle("Trainers");
            break;
          case R.id.profile:
            break;

        }
        item.setChecked(true);
        return false;
      }
    });

  }


  // loading home fragment
  private void loadHomeFragment(){
    Fragment homeFragment = new HomeFragment();
    loadFragment(homeFragment);
    setTitle("Home");
    atHome = true;
    bottomNav.getMenu().getItem(0).setChecked(true);
  }

  // setting the title to match the fragment
  private void setTitle(String title){
    getSupportActionBar().setTitle(title);
  }

  @Override
  public void onBackPressed() {
    if (mDrawer.isDrawerOpen(GravityCompat.START)){
      mDrawer.closeDrawer(GravityCompat.END);
    }else{
      if (atHome){
        super.onBackPressed();
      }else{
        loadHomeFragment();
      }
    }

  }
}
