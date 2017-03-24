package com.upload.genmed;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.util.ArrayList;

public class dbhandler {


    public static final String rowid = "_id";
    public static final String name = "name";
    public static final String password = "password";
    public static final String profile = "profile";


    public static final String med_name = "med_name";       //original medicine table attrbutes
    public static final String med_cost = "med_cost";
    public static final String gen_med = "gen_med";


    public static final String gen_name = "gen_name";       //generic medicine table attrbutes
    public static final String gen_cost = "gen_cost";

    public static final String gen_name2 = "gen_name2";       //medical store/status attributes
    public static final String shop = "shop";
    public static final String location = "location";
    public static final String availability = "availability";



    public static final String c_name = "c_name";       //comp  attributes
    public static final String country = "country";
    public static final String c_location = "c_location";
    public static final String net_worth = "net_worth";

    public static final String gen_name3 = "gen_name3";
    public static final String company = "company";




    private static final String database = "genmed";
    private static final String login_table = "login_table";
    private static final String med_table = "med_table";
    public static final String gen_table = "gen_table";
    public static final String store_table = "store_table";
    public static final String comp_table = "comp_table";
    public static final String med_comp_table = "med_comp_table";


    private static final int version = 1;

    private DBhelper helper;
    private final Context our_context;
    private SQLiteDatabase our_database;


    private static class DBhelper extends SQLiteOpenHelper {
            public DBhelper(Context context) {
            super(context, database, null, version);
        }




        @Override
        public void onCreate(SQLiteDatabase db) {
            String table1 = "CREATE TABLE " + login_table + " (" +
                    rowid + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    name + " TEXT NOT NULL, " +
                    password + " TEXT NOT NULL, " +
                    profile + " TEXT NOT NULL);";


            String table2 = "CREATE TABLE " + gen_table + " (" +         //EDIT THIS
                    gen_name + " TEXT PRIMARY KEY, " +
                    gen_cost + " TEXT NOT NULL);";


            String table3 = "CREATE TABLE " + med_table + " (" +         //EDIT THIS

                    med_name + " TEXT PRIMARY KEY NOT NULL, " +
                    med_cost + " TEXT NOT NULL, " +
                    gen_med + " TEXT, " +
                    " FOREIGN KEY (" + gen_med + ") REFERENCES " + gen_table + " (" + gen_name + "));";


            String table4 = "CREATE TABLE " + store_table + " (" +         //EDIT THIS

                    gen_name2 + " TEXT KEY NOT NULL, " +
                    shop + " TEXT NOT NULL, " +
                    location + " TEXT, " +
                    availability + " TEXT, " +

                    " FOREIGN KEY (" + gen_name2 + ") REFERENCES " + gen_table + " (" + gen_name + "));";


            String table5 = "CREATE TABLE " + comp_table + " (" +
                    c_name + " TEXT PRIMARY KEY, " +
                    country + " TEXT NOT NULL, " +
                    c_location+ " TEXT NOT NULL, " +
                    net_worth + " TEXT NOT NULL);";


            String table6 = "CREATE TABLE " + med_comp_table + " (" +         //EDIT THIS

                    gen_name3 + " TEXT KEY NOT NULL, " +
                    company + " TEXT NOT NULL, " +

                    " FOREIGN KEY (" + company + ") REFERENCES " + comp_table + " (" + c_name + "));";



            db.execSQL(table1);
            // Toast.makeText(dbhandler.this, "table created ", Toast.LENGTH_LONG).show();
            db.execSQL(table2);
            db.execSQL(table3);
            db.execSQL(table4);
            db.execSQL(table5);
            db.execSQL(table6);




            db.execSQL("INSERT INTO " + gen_table + " VALUES('pantaprazole','100')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('paracetamol','20')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('disprin','50')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('ranitidine','32')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('timolol maleate','30')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('oxycodone','90')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('triamterene','20')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('betaxolol','60')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('furosemide','10')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('fexofenadine','53')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('donepezil','5')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('ciprofloxacin','98')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('meperidine','52')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('zaleplon','40')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('propafenone','47')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('ribavirin caps','7')");
            db.execSQL("INSERT INTO " + gen_table + " VALUES('phenazopyridine','59')");


            db.execSQL("INSERT INTO " + med_table + " VALUES('pantop','200','pantaprazole')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('pand','150','pantaprazole')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('calpol','80','paracetamol')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('crocin','90','paracetamol')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('zantac','200','ranitidine')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('timoptic','100','timolol maleate')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('timoptic ocudose','220','timolol maleate')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('roxicodone','175','oxycodone')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('maxzide-25','90','triamterene')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('kerlone','75','betaxolol')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('lasix','310','furosemide')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('allegra','270','fexofenadine')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('aricept','10','donepezil')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('ciloxan','178','ciprofloxacin')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('demerol','300','meperidine')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('sonata','210','zaleplon')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('rythmol','90','propafenone')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('rebetol','20','ribavirin caps')");
            db.execSQL("INSERT INTO " + med_table + " VALUES('pyridium','170','phenazopyridine')");




            db.execSQL("INSERT INTO " + store_table + " VALUES('pantaprazole','kc','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('pantaprazole','manna','udupi','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('disprin','xyz','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('ranitidine','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('timolol maleate','Sudha Medicals','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('oxycodone','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('triamterene','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('furosemide','Sudha Medicals','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('betaxolol','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('fexofenadine','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('donepezil','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('ciprofloxacin','Sudha Medicals','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('meperidine','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('zaleplon','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('propafenone','Sudha Medicals','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('ribavirin','Sudha Medicals','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('phenazopyridine','Sudha Medicals','manipal','y')");

            db.execSQL("INSERT INTO " + store_table + " VALUES('ranitidine','Manipal pharmacy','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('timolol maleate','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('oxycodone','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('triamterene','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('furosemide','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('betaxolol','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('fexofenadine','Manipal pharmacy','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('donepezil','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('ciprofloxacin','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('meperidine','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('zaleplon','Manipal pharmacy','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('propafenone','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('ribavirin','Manipal pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('phenazopyridine','Manipal pharmacy','manipal','n')");


            db.execSQL("INSERT INTO " + store_table + " VALUES('ranitidine','Satellite Pharmacy','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('timolol maleate','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('oxycodone','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('triamterene','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('furosemide','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('betaxolol','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('fexofenadine','Satellite Pharmacy','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('donepezil','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('ciprofloxacin','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('meperidine','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('zaleplon','Satellite Pharmacy','manipal','n')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('propafenone','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('ribavirin','Satellite Pharmacy','manipal','y')");
            db.execSQL("INSERT INTO " + store_table + " VALUES('phenazopyridine','Satellite Pharmacy','manipal','n')");




            db.execSQL("INSERT INTO " + comp_table + " VALUES('McKesson','USA','San Francisco','131')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('Abbott Laboratories','USA','illinois','60')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('Eli Lilly & Co.','USA','Indianapolis','66')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('AstraZeneca','UK','london','82.3')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('GlaxoSmithKline','UK','london','129')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('Merck & Co.','USA','New Jersey','106')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('Roche Holding','Switzerland','Basel','253')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('Sanofi','France','Paris','138')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('Novartis','Switzerland','Basel','227.4')");
            db.execSQL("INSERT INTO " + comp_table + " VALUES('Pfizer','USA','New York','172.1')");



            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('zantac','McKesson')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('timoptic','Abbott Laboratories')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('timoptic ocudose','Eli Lilly & Co.')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('roxicodone','AstraZeneca')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('maxzide-25','GlaxoSmithKline')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('kerlone','Merck & Co.')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('lasix','Roche Holding')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('allegra','Sanofi')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('aricept','Novartis')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('ciloxan','Pfizer')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('demerol','Pfizer')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('sonata','Novartis')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('rythmol','Roche Holding')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('rebetol','Merck & Co.')");
            db.execSQL("INSERT INTO " + med_comp_table + " VALUES('pyridium','Novartis')");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + login_table);
            db.execSQL("DROP TABLE IF EXISTS " + med_table);
            db.execSQL("DROP TABLE IF EXISTS " + gen_table);

            onCreate(db);
        }
    }


    public dbhandler(Context context) {
        our_context = context;
    }


    public dbhandler open() throws SQLException {
        helper = new DBhelper(our_context);
        our_database = helper.getWritableDatabase();
        return this;
    }

    public void close() {
        helper.close();
    }


    public long createRecord(String username, String pass, String prof) {
        ContentValues cv = new ContentValues();
        cv.put(name, username);
        cv.put(password, pass);
        cv.put(profile, prof);
        return our_database.insert(login_table, null, cv);

    }


    public long createStore(String gen_name, String store, String loc, String available) {
        ContentValues cv = new ContentValues();
        cv.put(gen_name2, gen_name);
        cv.put(shop, store);
        cv.put(location, loc);
        cv.put(availability, available);

        return our_database.insert(store_table, null, cv);

    }               //create store method.

    public long createMed(String med, String cost, String gen_name) {
        ContentValues cv = new ContentValues();
        cv.put(med_name, med);
        cv.put(med_cost, cost);
        cv.put(gen_med, gen_name);

        return our_database.insert(med_table, null, cv);

    }               ///create medicine database

    public long createGen(String gen, String cost) {
        ContentValues cv = new ContentValues();
        cv.put(gen_name, gen);
        cv.put(gen_cost, cost);

        return our_database.insert(gen_table, null, cv);

    }       //create generic database


    public String getData() {
        String[] columns = new String[]{rowid, name, password, profile};
        Cursor c1 = our_database.query(login_table, columns, null, null, null, null, null);
        String result = " ";

        int iRow = c1.getColumnIndex(rowid);
        int iname = c1.getColumnIndex(name);
        int ipass = c1.getColumnIndex(password);
        int iprof = c1.getColumnIndex(profile);

        for (c1.moveToFirst(); !c1.isAfterLast(); c1.moveToNext()) {
            result = result + c1.getString(iRow) + "   " + c1.getString(iname) + "   " + c1.getString(ipass) + "   " + c1.getString(iprof) + "\n  ";


        }
        return result;

    }

    public String searchPass(String user) {

        String[] columns = new String[]{name, password};
        Cursor c2 = our_database.query(login_table, columns, null, null, null, null, null);

        //String query=" select name,password from " + login_table;
        //Cursor c2=our_database.rawQuery(query,null);
        int iname = c2.getColumnIndex(name);
        int ipass = c2.getColumnIndex(password);
        String name;
        String password = "";
        if (c2.moveToFirst()) {
            do {
                name = c2.getString(iname);

                if (name.equals(user)) {
                    password = c2.getString(ipass);
                    break;
                }

            }
            while (c2.moveToNext());

        }
        return password;

    }


    public String[] search(String med) {

        String query = "SELECT " + med_name + "," + med_cost + "," + gen_med + "," + gen_cost + " FROM " + gen_table + " CROSS JOIN " + med_table + " WHERE " + gen_med + "=" + gen_name + " AND " + med_name + "='" + med + "'";
        Cursor c3 = our_database.rawQuery(query, null);
        String result[] = new String[4];
        int imed = c3.getColumnIndex(med_name);
        int imcost = c3.getColumnIndex(med_cost);
        int igen = c3.getColumnIndex(gen_med);
        int igcost = c3.getColumnIndex(gen_cost);

        for (c3.moveToFirst(); !c3.isAfterLast(); c3.moveToNext()) {
            result[0] = c3.getString(imed);
            result[1] = c3.getString(imcost);
            result[2] = c3.getString(igen);
            result[3] = c3.getString(igcost);


        }
        return result;

    }




    ///////////shit//////////////////




    public ArrayList<String> searchStore(String med){
        ArrayList<String> result=new ArrayList<>();
        String s1;
        String s2;
        String s3;

        //String query="SELECT * FROM "+store_table+ " WHERE "+gen_name2+"='"+ med +"'";

        String query = "SELECT " + shop + "," + location + "," + availability  + " FROM " + store_table + " CROSS JOIN " + gen_table + " WHERE " + gen_name2 + "=" + gen_name + " AND " + gen_name2 + "='" + med+"'";
        Cursor c3 = our_database.rawQuery(query, null);

        int iShop = c3.getColumnIndex(shop);
        int iLoc = c3.getColumnIndex(location);
        int iavail = c3.getColumnIndex(availability);

        //int iprof = c3.getColumnIndex(profile);

        for (c3.moveToFirst(); !c3.isAfterLast(); c3.moveToNext()) {

            s1=c3.getString(iShop) + "     ";
            s2=c3.getString(iLoc) + "     ";
            s3=c3.getString(iavail) + "\n  ";
            result.add(s1+s2+s3);


        }
        return result;

    }


    public String[] searchComp(String med) {

        String query = "SELECT " + c_name + "," + country + "," + c_location + "," + net_worth + " FROM " + med_comp_table + " CROSS JOIN " + comp_table + " WHERE " + company + "=" + c_name + " AND " + gen_name3 + "='" + med + "'";
        Cursor c3 = our_database.rawQuery(query, null);
        String result[] = new String[4];
        int iname = c3.getColumnIndex(c_name);
        int icount = c3.getColumnIndex(country);
        int iloc = c3.getColumnIndex(c_location);
        int iworth = c3.getColumnIndex(net_worth);

        for (c3.moveToFirst(); !c3.isAfterLast(); c3.moveToNext()) {
            result[0] = c3.getString(iname);
            result[1] = c3.getString(icount);
            result[2] = c3.getString(iloc);
            result[3] = c3.getString(iworth);


        }
        return result;

    }


}
















