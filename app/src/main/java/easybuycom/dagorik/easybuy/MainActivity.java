package easybuycom.dagorik.easybuy;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import easybuycom.dagorik.easybuy.fragments.OneFragment;
import easybuycom.dagorik.easybuy.fragments.ThreeFragment;
import easybuycom.dagorik.easybuy.fragments.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.iablayout);

        tabLayout.setupWithViewPager(viewPager);

    }


    //Se adapta el ViewPager y se agrega el titulo del appBar a los fragmentos
    private void setupViewPager(ViewPager viewPager) {
        //Creando objeto del ViewPagerAdapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Historial");
        adapter.addFragment(new TwoFragment(), "Plan De Compra");
        adapter.addFragment(new ThreeFragment(), "Plan de ahorro");
        viewPager.setAdapter(adapter);

    }


    //Adaptador del ViewPager
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }

}

