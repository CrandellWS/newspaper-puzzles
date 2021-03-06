package ws.crandell.newspaperpuzzles.crossword;

import ws.crandell.newspaperpuzzles.crossword.nppcrossword.NPPCrosswordsApplication;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

import ws.crandell.newspaperpuzzles.R;


public class PreferencesActivity extends PreferenceActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.cw_preferences);

        Preference release = (Preference) findPreference("releaseNotes");
        release.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference arg0) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("file:///android_asset/cw_release.html"),
                            PreferencesActivity.this, HTMLActivity.class);
                    PreferencesActivity.this.startActivity(i);

                    return true;
                }
            });

        Preference license = (Preference) findPreference("license");
        license.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference arg0) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("file:///android_asset/cw_license.html"),
                            PreferencesActivity.this, HTMLActivity.class);
                    PreferencesActivity.this.startActivity(i);

                    return true;
                }
            });

        Preference subscribeNyt = (Preference) findPreference("nytSubscribe");
        subscribeNyt.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference arg0) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nytimes.com/puzzle"));
                    PreferencesActivity.this.startActivity(i);

                    return true;
                }
            });

        Preference scrapeInfo = (Preference) findPreference("aboutScrapes");
        scrapeInfo.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference arg0) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("file:///android_asset/cw_scrapes.html"),
                            PreferencesActivity.this, HTMLActivity.class);
                    PreferencesActivity.this.startActivity(i);

                    return true;
                }
            });
        
        Preference sendDebug = (Preference) findPreference("sendDebug");
        sendDebug.setOnPreferenceClickListener(new OnPreferenceClickListener(){

			public boolean onPreferenceClick(Preference preference) {
				startActivity(NPPCrosswordsApplication.sendDebug());
				return true;
			}
        	
        });
    }
}
