module org.marcosbrindis.proyectomultidiciplinario {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.marcosbrindis.proyectomultidiciplinario to javafx.fxml;
    exports org.marcosbrindis.proyectomultidiciplinario;
}