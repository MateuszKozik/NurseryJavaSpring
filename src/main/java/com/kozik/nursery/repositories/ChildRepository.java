
package com.kozik.nursery.repositories;

import com.kozik.nursery.entities.Child;
import com.kozik.nursery.entities.Parent;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, String>{

    public boolean existsByPesel(String pesel);
    List<Child> findByParents(Parent parent);
    List<Child> findByParentsAndEnrolled(Parent parent, Boolean enrolled);
}
