package DomainClasses;

import java.util.List;

public interface Filtrable {
   void CharacterRange(Publication PublicationSize);
   void ChangeFont(Publication Pub) throws InterruptedException;
   void Fontsize(Publication PublicationImage);
}
