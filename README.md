# FabMenu

TODO: Write a project description

## Installation

      compile 'com.zyceeit.android.fabmenu:fabmenu:0.1.0'

## Usage

      <com.zyceeit.android.fabmenu.FabMenu
        android:id="@+id/fabMenu"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true" />
        
        
      FabMenu fabMenu = (FabMenu) findViewById(R.id.fabMenu);
      fabMenu.addFab();
      fabMenu.addFab();
      fabMenu.addFab();
      fabMenu.addFab();
      
      List<View.OnClickListener> onClickListenerList = new ArrayList<>();
      
      onClickListenerList.add(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sub 1", Toast.LENGTH_SHORT).show();
            }
        });

      onClickListenerList.add(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sub 2", Toast.LENGTH_SHORT).show();
            }
      });

      onClickListenerList.add(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "sub 3", Toast.LENGTH_SHORT).show();
            }
      });
      
      fabMenu.setSubFabOnClickListener(onClickListenerList);
      
      

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :grin:

## History

TODO: Write history

## Credits

TODO: Write credits

## License

TODO: Write license
