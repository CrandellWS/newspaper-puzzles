package ws.crandell.newspaperpuzzles.crossword.nppcrossword;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;


public class BackupAgent extends BackupAgentHelper {
    static final String PREFS = "ws.crandell.newspaperpuzzles.crossword.shortyz_preferences";
    static final String PREFS_BACKUP_KEY = "prefs";

    public void onCreate() {
        SharedPreferencesBackupHelper helper = new SharedPreferencesBackupHelper(this, PREFS);
        addHelper(PREFS_BACKUP_KEY, helper);
    }
}
