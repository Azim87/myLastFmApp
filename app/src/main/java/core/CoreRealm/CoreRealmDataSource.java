package core.CoreRealm;

import android.util.Log;

import io.realm.Realm;

public abstract class CoreRealmDataSource {

    protected Realm getRealmInstance(){
        return Realm.getDefaultInstance();
    }

    protected void executeTransaction(Realm.Transaction transaction){
        Realm realm = null;

        try {
            realm = getRealmInstance();
            realm.executeTransaction(transaction);
        }catch (Exception e){
            Log.d("ololo", "e" + e.getMessage());
        }finally {
            if (realm != null){
                realm.close();
            }
        }
    }

    protected long getNextId(Class c){
        Realm realm = null;

        try {
            realm = getRealmInstance();
            String primaryKeyFiled = realm.getSchema()
                    .get(c.getSimpleName())
                    .getPrimaryKey();

            if (realm.where(c).max(primaryKeyFiled) == null){
                return 1;
            }

            int value = realm.where(c).max(primaryKeyFiled).intValue();
            return  value + 1;

        }catch (Exception e){
            Log.d("ololo", "e" + e.getMessage());
            return - 1;
        }finally {
            if (realm != null){
                realm.close();
            }
        }
    }
}
