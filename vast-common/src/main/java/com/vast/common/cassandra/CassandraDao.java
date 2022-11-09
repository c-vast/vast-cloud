package com.vast.common.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CassandraDao<T,ID> extends CassandraRepository<T,ID> {
}
