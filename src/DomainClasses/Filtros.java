package DomainClasses;

import java.util.ArrayList;
import java.util.List;

public class Filtros {
    private List<String> atributos;
    private List<Publication> publicacionesOriginales;

    public Filtros(List<String> atributos, List<Publication> publicacionesOriginales) {
        this.atributos = atributos;
        this.publicacionesOriginales = publicacionesOriginales;
    }

    public List<Publication> filtrarPublicaciones(String atributo, String valor) {
        List<Publication> publicacionesFiltradas = new ArrayList<>();

        for (Publication publication : publicacionesOriginales) {
            if (cumpleFiltro(publication, atributo, valor)) {
                publicacionesFiltradas.add(publication);
            }
        }

        return publicacionesFiltradas;
    }

    private boolean cumpleFiltro(Publication publicacion, String atributo, String valor) {
        switch (atributo) {
            case "CantidadMegusta":
                return publicacion.getLikes() >= Integer.parseInt(valor);
            case "Duracion":
                if (publicacion instanceof Video)
                    return ((Video) publicacion).getDuration() >= Integer.parseInt(valor);
                else
                if (publicacion instanceof Audio)
                    return ((Audio) publicacion).getDuration() >= Integer.parseInt(valor);
            case "FechaSubida":
                return publicacion.getUploadDate().equals(valor);
            case "Hashtags":
                return publicacion.getHashtags().contains(valor);
            default:
                return false;
        }
    }
}