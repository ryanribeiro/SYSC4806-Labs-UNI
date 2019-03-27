package model;

import model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, String> {

    List<BuddyInfo> findByName(String name);
}