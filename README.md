# Nice Start

## Mi primer proyecto en android studio

```xml
<com.google.android.material.textfield.TextInputLayout
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    app:passwordToggleEnabled="true"
    app:startIconDrawable="@drawable/keyicon">
    
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:alpha="0.6"
        android:background="@android:color/white"
        android:hint="@string/password"
        android:inputType="textPassword"
        android:drawableLeft="@drawable/keyicon"/>
    
</com.google.android.material.textfield.TextInputLayout>
```

# Mi pantalla de carga
Esta pantalla cuenta con una animación en el logo en la que se mueve para arriba y luego vuelve a bajar (transition), tiene un blink y rota sobre si mismo.

![pantalla de carga](./img/loading.gif)

# Mi pantalla de Login

![pantalla de login](./img/login.png)

# Mi pantalla de Registro

![pantalla de registro](./img/signup.png)

# Mi pantalla principal
Esta pantalla cuenta con un menú contextual al mantener pulsado el texto situado en el centro.
También cuenta con un menú appbar y con un swipe refresh.

![pantalla principal](./img/main.png)

### Menú contextual
![menu context](./img/menu_context.png)

### Menú appbar
![menu appbar](./img/menu_appbar.png)

### Swipe Refresh
![swipe refresh](./img/swipe_refresh.png)

# The key...
En el centro podemos ver un texto indicandonos que encontremos la llave.
La llave en un icono ubicado en el menú action bar (arriba a la derecha).

![key action icon](./img/key_icon.png)

Al pulsarlo nos aparece un snackbar diciendonos que hemos encontrado la llave y si queremos devolverla (devolverla sería reiniciar el juego).

![snackbar](./img/snackbar.png)

# Código del snackbar
```java
Snackbar snackbar = Snackbar.make(findViewById(R.id.itemKey), "Key collected", BaseTransientBottomBar.LENGTH_LONG);

snackbar.setAction("Return the key", new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mycontext.setText("Find the key...");
    }
});

snackbar.show();
```

# Dialogo modal
El dialogo modal se muestra al hacer click en los tres puntitos del app bar y pulsar en la opción settings.

![appbar_dots](./img/appbar_dots.png) ![appbar_settings](./img/appbar_settings.png)

La opción de "Yes" cierra la aplicación.
La opción de "No" cierra el dialogo modal y muestra un Toast.
La opción "Do nothing" simplemente cierra el dialogo modal.

![modal_dialog](./img/modal_dialog.png)

```java
public void showAlertDialogButtonClicked(MainActivity mainActivity) {
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(mainActivity);

    builder.setTitle("Exit!");
    builder.setMessage("Do you want to exit the app?");
    builder.setIcon(R.drawable.person);

    builder.setNeutralButton("Do nothing", new
            DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

    builder.setNegativeButton("No", new
            DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(mainActivity, "Okay", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });

    builder.setPositiveButton("Yes", new
            DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });

    AlertDialog dialog = builder.create();
    dialog.show();
}
```

> ##### Si consideras útil el repositorio, apóyalo haciendo "★ Star" en el repositorio. ¡Gracias!

>This repository is licensed under
>[Creativecommons Org Licenses By Sa 4](http://creativecommons.org/licenses/by-sa/4.0/)