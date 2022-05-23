// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEventBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardEventBinding eventPost;

  @NonNull
  public final ListView lvEvent;

  private FragmentEventBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardEventBinding eventPost, @NonNull ListView lvEvent) {
    this.rootView = rootView;
    this.eventPost = eventPost;
    this.lvEvent = lvEvent;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_event, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEventBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.eventPost;
      View eventPost = ViewBindings.findChildViewById(rootView, id);
      if (eventPost == null) {
        break missingId;
      }
      CardEventBinding binding_eventPost = CardEventBinding.bind(eventPost);

      id = R.id.lvEvent;
      ListView lvEvent = ViewBindings.findChildViewById(rootView, id);
      if (lvEvent == null) {
        break missingId;
      }

      return new FragmentEventBinding((ConstraintLayout) rootView, binding_eventPost, lvEvent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
