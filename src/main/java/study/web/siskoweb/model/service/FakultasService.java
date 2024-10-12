package study.web.siskoweb.model.service;

import study.web.siskoweb.model.request.FakultasReq;
import study.web.siskoweb.model.response.FakultasRes;

import java.util.List;
import java.util.Optional;

public interface FakultasService {
    List<FakultasRes> get();
    Optional<FakultasRes> getByid(String  id);
    Optional<FakultasRes> save(FakultasReq req);
    Optional<FakultasRes> update(String id, FakultasReq req);
    Optional<FakultasRes> delete(String id);

}
