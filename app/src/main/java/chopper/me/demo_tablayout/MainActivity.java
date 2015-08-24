package chopper.me.demo_tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);


        // 重力 one of GRAVITY_CENTER or GRAVITY_FILL.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        // 背景色
        tabLayout.setBackgroundColor(getResources().getColor(R.color.blue));

        // 字体颜色（正常/选中）
        tabLayout.setTabTextColors(
                getResources().getColor(R.color.font_color_normal_black),
                getResources().getColor(R.color.font_color_deep_black));

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(MyFragment.newInstance(1), "tab1");
        adapter.addFragment(MyFragment.newInstance(2), "tab2");
        adapter.addFragment(MyFragment.newInstance(3), "tab3");
        adapter.addFragment(MyFragment.newInstance(4), "tab4");
        viewPager.setAdapter(adapter);


        // setupWithViewPager
        tabLayout.setupWithViewPager(viewPager);

    }

    private static class MyPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> myFragments = new ArrayList<Fragment>();
        private final List<String> myFragmentTitles = new ArrayList<String>(); // Title对应在TabLayout上面

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            myFragments.add(fragment);
            myFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int arg0) {
            return myFragments.get(arg0);
        }

        @Override
        public int getCount() {
            return myFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return myFragmentTitles.get(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
