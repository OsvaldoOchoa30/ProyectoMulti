module org.marcosbrindis.proyectomultidiciplinario {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.marcosbrindis.proyectomultidiciplinario.models;
    opens org.marcosbrindis.proyectomultidiciplinario to javafx.fxml;
    exports org.marcosbrindis.proyectomultidiciplinario;
    exports org.marcosbrindis.proyectomultidiciplinario.controllers;
    opens org.marcosbrindis.proyectomultidiciplinario.controllers to javafx.fxml;
}