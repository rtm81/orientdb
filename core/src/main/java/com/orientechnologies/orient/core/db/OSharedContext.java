package com.orientechnologies.orient.core.db;

import com.orientechnologies.common.concur.resource.OCloseable;
import com.orientechnologies.common.profiler.OProfiler;
import com.orientechnologies.orient.core.Orient;
import com.orientechnologies.orient.core.cache.OCommandCache;
import com.orientechnologies.orient.core.cache.OCommandCacheSoftRefs;
import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.index.*;
import com.orientechnologies.orient.core.metadata.function.OFunctionLibraryImpl;
import com.orientechnologies.orient.core.metadata.schema.OSchemaShared;
import com.orientechnologies.orient.core.metadata.security.OSecurity;
import com.orientechnologies.orient.core.metadata.sequence.OSequenceLibraryImpl;
import com.orientechnologies.orient.core.query.live.OLiveQueryHook;
import com.orientechnologies.orient.core.schedule.OSchedulerImpl;
import com.orientechnologies.orient.core.security.OSecurityManager;
import com.orientechnologies.orient.core.sql.executor.OQueryStats;
import com.orientechnologies.orient.core.sql.parser.OStatementCache;
import com.orientechnologies.orient.core.storage.OStorage;
import com.orientechnologies.orient.core.storage.OStorageProxy;

/**
 * Created by tglman on 15/06/16.
 */
public abstract class OSharedContext implements OCloseable {
  protected static final OProfiler PROFILER = Orient.instance().getProfiler();
  protected OSchemaShared                schema;
  protected OSecurity                    security;
  protected OIndexManagerAbstract        indexManager;
  protected OFunctionLibraryImpl         functionLibrary;
  protected OSchedulerImpl               scheduler;
  protected OSequenceLibraryImpl         sequenceLibrary;
  protected OLiveQueryHook.OLiveQueryOps liveQueryOps;
  protected OCommandCache                commandCache;
  protected OStatementCache              statementCache;
  protected OQueryStats                  queryStats;
  protected volatile boolean loaded = false;

  public OSchemaShared getSchema() {
    return schema;
  }

  public OSecurity getSecurity() {
    return security;
  }

  public OIndexManagerAbstract getIndexManager() {
    return indexManager;
  }

  public OFunctionLibraryImpl getFunctionLibrary() {
    return functionLibrary;
  }

  public OSchedulerImpl getScheduler() {
    return scheduler;
  }

  public OSequenceLibraryImpl getSequenceLibrary() {
    return sequenceLibrary;
  }

  public OLiveQueryHook.OLiveQueryOps getLiveQueryOps() {
    return liveQueryOps;
  }

  public OCommandCache getCommandCache() {
    return commandCache;
  }

  public OStatementCache getStatementCache() {
    return statementCache;
  }

  public OQueryStats getQueryStats() {
    return queryStats;
  }

  public abstract void load(ODatabaseDocumentInternal oDatabaseDocumentInternal);

  public abstract void reload(ODatabaseDocumentInternal database);
}
