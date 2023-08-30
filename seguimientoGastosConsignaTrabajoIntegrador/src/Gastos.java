import java.time.LocalDateTime;
public abstract class Gastos {
    private String nombreGasto;
    private int montoGasto;
    private LocalDateTime fechaHoraGasto;
    private String categoria;
    private String descripcion;

    public Gastos() {
    }

    public Gastos(String nombreGasto, int montoGasto, LocalDateTime fechaHoraGasto, String categoria, String descripcion) {
        this.nombreGasto = nombreGasto;
        this.montoGasto = montoGasto;
        this.fechaHoraGasto = fechaHoraGasto;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public String getNombreGasto() {
        return nombreGasto;
    }

    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

    public int getMontoGasto() {
        return montoGasto;
    }

    public void setMontoGasto(int montoGasto) {
        this.montoGasto = montoGasto;
    }

    public LocalDateTime getFechaHoraGasto() {
        return fechaHoraGasto;
    }

    public void setFechaHoraGasto(int year, int month, int day, int hour, int minute) {
        this.fechaHoraGasto = LocalDateTime.of(year, month, day, hour, minute);
    }

    public String getCategoria() {

        return categoria;
    }

    public void setCategoria(String categoria) {

        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
