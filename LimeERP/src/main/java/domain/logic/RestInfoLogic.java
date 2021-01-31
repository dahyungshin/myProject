package domain.logic;

import domain.dto.RestInfoDto;
import domain.spec.RestInfoService;
import store.RestInfoStore;

import java.util.List;

public class RestInfoLogic implements RestInfoService {

    private RestInfoStore restInfoStore;

    public RestInfoLogic(RestInfoStore restInfoStore) {
        this.restInfoStore = restInfoStore;
    }

    @Override
    public List<RestInfoDto> findList() {
        return this.restInfoStore.retrieve();
    }
}
