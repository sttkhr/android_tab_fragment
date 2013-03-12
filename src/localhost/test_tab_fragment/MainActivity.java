package localhost.test_tab_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class MainActivity extends FragmentActivity  implements TabHost.OnTabChangeListener {

	// TabHost
    private TabHost mTabHost;
    // Last selected tabId
    private String mLastTabId;    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);
        
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();        
        
        /* Tab1 設定 */
        TabSpec tab1 = mTabHost.newTabSpec("tab1");
        tab1.setIndicator("TAB1");                  
        tab1.setContent(new DummyTabFactory(this)); 
        mTabHost.addTab(tab1); 
        
        // Tab2 設定
        TabSpec tab2 = mTabHost.newTabSpec("tab2");
        tab2.setIndicator("TAB2");                  
        tab2.setContent(new DummyTabFactory(this)); 
        mTabHost.addTab(tab2);
        
        // Tab3 設定
        TabSpec tab3 = mTabHost.newTabSpec("tab3");
        tab3.setIndicator("TAB3");                  
        tab3.setContent(new DummyTabFactory(this)); 
        mTabHost.addTab(tab3);   
        
        // タブ変更時イベントハンドラ
        mTabHost.setOnTabChangedListener(this);

        // 初期タブ選択
        onTabChanged("tab1");        
    }
    
    /*
     * タブの選択が変わったときに呼び出される
     * @Override
     */
    public void onTabChanged(String tabId) {
    	Log.d("TAB_FRAGMENT_LOG","tabId:" + tabId);
    	if(mLastTabId != tabId){
            FragmentTransaction fragmentTransaction 
                 = getSupportFragmentManager().beginTransaction();
            if("tab1" == tabId){
            	fragmentTransaction
            		.replace(R.id.realtabcontent, new Tab1Fragment());
            }else if("tab2" == tabId){
            	fragmentTransaction
            		.replace(R.id.realtabcontent, new Tab2Fragment());
            }else if("tab3" == tabId){
            	fragmentTransaction
            		.replace(R.id.realtabcontent, new Tab3Fragment());
            }
    		mLastTabId = tabId;
    		fragmentTransaction.commit();
    	}
    }   
    
    /*
     * android:id/tabcontent のダミーコンテンツ
     */
    private static class DummyTabFactory implements TabContentFactory {

        /* Context */
        private final Context mContext;

        DummyTabFactory(Context context) {
            mContext = context;
        }

        @Override
        public View createTabContent(String tag) {
            View v = new View(mContext);
            return v;
        }
    }  
}
