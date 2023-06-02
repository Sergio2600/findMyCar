// Generated by view binder compiler. Do not edit!
package com.example.findmycar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.findmycar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button botonCrearCuenta;

  @NonNull
  public final Button buttonIniciar;

  @NonNull
  public final EditText cajapass;

  @NonNull
  public final EditText cajausuario;

  @NonNull
  public final ImageView imageView2;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button botonCrearCuenta,
      @NonNull Button buttonIniciar, @NonNull EditText cajapass, @NonNull EditText cajausuario,
      @NonNull ImageView imageView2) {
    this.rootView = rootView;
    this.botonCrearCuenta = botonCrearCuenta;
    this.buttonIniciar = buttonIniciar;
    this.cajapass = cajapass;
    this.cajausuario = cajausuario;
    this.imageView2 = imageView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.botonCrearCuenta;
      Button botonCrearCuenta = ViewBindings.findChildViewById(rootView, id);
      if (botonCrearCuenta == null) {
        break missingId;
      }

      id = R.id.buttonIniciar;
      Button buttonIniciar = ViewBindings.findChildViewById(rootView, id);
      if (buttonIniciar == null) {
        break missingId;
      }

      id = R.id.cajapass;
      EditText cajapass = ViewBindings.findChildViewById(rootView, id);
      if (cajapass == null) {
        break missingId;
      }

      id = R.id.cajausuario;
      EditText cajausuario = ViewBindings.findChildViewById(rootView, id);
      if (cajausuario == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, botonCrearCuenta, buttonIniciar,
          cajapass, cajausuario, imageView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
