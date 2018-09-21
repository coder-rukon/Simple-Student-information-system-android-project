package net.digitalbd.studentdetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class Db extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    public Context context;
    public static final String db_Name = "std_details";
    public SQLiteDatabase db;
    String studentTable = "students";
    public Db(Context context) {
        super(context, db_Name, null, 1);
        db = this.getWritableDatabase();
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+studentTable+"(id INTEGER PRIMARY KEY AUTOINCREMENT,name text,stdid text,contact text,details text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+studentTable);
        onCreate(db);
    }

    public long addStudent(Student student){
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("stdId", student.getId());
        values.put("contact", student.getContact());
        values.put("details", student.getDetails());
        return db.insert(studentTable, null, values);
    }

    public void deleteStudent(String id){
        db.execSQL("DELETE FROM " + studentTable + " WHERE id ='"+id+"' ");
    }

    public ArrayList<Student> getAllStudent(){
        String name = "",id="",stdId="",contact="",details="";
        ArrayList<Student> allStudents = new ArrayList<Student>();
        Cursor cursor = db.rawQuery("select * from "+studentTable,null);

        while (cursor.moveToNext()){
            id = cursor.getString(0);
            name = cursor.getString(1);
            stdId = cursor.getString(2);
            contact = cursor.getString(3);
            details = cursor.getString(4);

            Student student = new Student(name,stdId,details,id,contact);
            allStudents.add(student);
        }
        return  allStudents;
    }


}
