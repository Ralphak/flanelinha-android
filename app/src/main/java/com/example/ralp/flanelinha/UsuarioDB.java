package com.example.ralp.flanelinha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDB extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "listaUsuarios";

    // Table name
    private static final String TABLE = "usuarios";

    // Table Columns names
    private static final String KEY_EMAIL = "email";
    private static final String KEY_NAME = "nome";
    private static final String KEY_PWD = "senha";

    public UsuarioDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE + "("
                + KEY_EMAIL + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PWD + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void add(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, usuario.getEmail());
        values.put(KEY_NAME, usuario.getNome());
        values.put(KEY_PWD, usuario.getSenha());

        // Inserting Row
        db.insert(TABLE, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    public Usuario get(String _email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE, new String[] {KEY_EMAIL,
                        KEY_NAME, KEY_PWD}, KEY_EMAIL + "=?",
                new String[] { _email }, null, null, null, null);

        if (cursor == null)
            return null;

        cursor.moveToFirst();

        Usuario usuario = new Usuario(cursor.getString(0),
                cursor.getString(1), cursor.getString(2));

        db.close();
        return usuario;
    }

    // Getting All Contacts
    public List<Usuario> getAll() {
        List<Usuario> lista = new ArrayList<Usuario>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //Este objeto Usuario NÃO carrega as senhas!
                Usuario usuario = new Usuario(cursor.getString(0), cursor.getString(1));
                lista.add(usuario);
            } while (cursor.moveToNext());
        }

        db.close();

        // return contact list
        return lista;
    }

    // Updating single contact
    public void updatePassword(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PWD, usuario.getSenha());

        // updating row
        db.update(TABLE, values, KEY_EMAIL + " = ?",
                new String[] { usuario.getEmail() });

        db.close();
    }

    // Deleting single contact
    public void delete(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE, KEY_EMAIL + " = ?",
                new String[] { usuario.getEmail() });
        db.close();
    }

}