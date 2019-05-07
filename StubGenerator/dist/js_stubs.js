konan.libraries.push({

  knjs_get__Game_constructionSites: (resultArena) = > {
  const result = Game.constructionSites;
return toArena(resultArena, result);
},

knjs_get__Game_cpu: (resultArena) =
>
{
  const result = Game.cpu;
  return toArena(resultArena, result);
}
,

knjs_get__Game_creeps: (resultArena) =
>
{
  const result = Game.creeps;
  return toArena(resultArena, result);
}
,

knjs_get__Game_flags: (resultArena) =
>
{
  const result = Game.flags;
  return toArena(resultArena, result);
}
,

knjs_get__Game_gcl: (resultArena) =
>
{
  const result = Game.gcl;
  return toArena(resultArena, result);
}
,

knjs_get__Game_gpl: (resultArena) =
>
{
  const result = Game.gpl;
  return toArena(resultArena, result);
}
,

knjs_get__Game_map: (resultArena) =
>
{
  const result = Game.map;
  return toArena(resultArena, result);
}
,

knjs_get__Game_time: () =
>
{
  const result = Game.time;
  return result;
}
,

knjs__Game_notify: (messagePtr, messageLen, groupInterval) =
>
{
  const message = toUTF16String(messagePtr, messageLen);
  const result = Game.notify(message, groupInterval);
  return;
}
,

knjs_get__Cpu_limit: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).limit;
  return result;
}
,

knjs_get__Cpu_tickLimit: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).tickLimit;
  return result;
}
,

knjs_get__Cpu_bucket: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).bucket;
  return result;
}
,

knjs_get__Cpu_shardLimits: (arena, obj, resultArena) =
>
{
  const result = kotlinObject(arena, obj).shardLimits;
  return toArena(resultArena, result);
}
,

knjs_get__Gcl_level: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).level;
  return result;
}
,

knjs_get__Gcl_progress: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).progress;
  return result;
}
,

knjs_get__Gcl_progressTotal: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).progressTotal;
  return result;
}
,

knjs_get__Gpl_level: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).level;
  return result;
}
,

knjs_get__Gpl_progress: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).progress;
  return result;
}
,

knjs_get__Gpl_progressTotal: (arena, obj) =
>
{
  const result = kotlinObject(arena, obj).progressTotal;
  return result;
}
,

knjs__GameMap_describeExits: (arena, obj, roomNamePtr, roomNameLen, resultArena) =
>
{
  const roomName = toUTF16String(roomNamePtr, roomNameLen);
  const result = kotlinObject(arena, obj).describeExits(roomName);
  return toArena(resultArena, result);
}
,

knjs__GameMap_findExit: (arena, obj, fromRoomPtr, fromRoomLen, toRoomPtr, toRoomLen) =
>
{
  const fromRoom = toUTF16String(fromRoomPtr, fromRoomLen);
  const toRoom = toUTF16String(toRoomPtr, toRoomLen);
  const result = kotlinObject(arena, obj).findExit(fromRoom, toRoom);
  return result;
}
,

knjs__GameMap_findRoute: (arena, obj, fromRoomPtr, fromRoomLen, toRoomPtr, toRoomLen, resultArena) =
>
{
  const fromRoom = toUTF16String(fromRoomPtr, fromRoomLen);
  const toRoom = toUTF16String(toRoomPtr, toRoomLen);
  const result = kotlinObject(arena, obj).findRoute(fromRoom, toRoom);
  return toArena(resultArena, result);
}
,

knjs_get__ExistDescriptor_1: (arena, obj, resultArena) =
>
{
  const result = kotlinObject(arena, obj)
  .1;
  return toArena(resultArena, result);
}
,

knjs_get__ExistDescriptor_3: (arena, obj, resultArena) =
>
{
  const result = kotlinObject(arena, obj)
  .3;
  return toArena(resultArena, result);
}
,

knjs_get__ExistDescriptor_5: (arena, obj, resultArena) =
>
{
  const result = kotlinObject(arena, obj)
  .5;
  return toArena(resultArena, result);
}
,

knjs_get__ExistDescriptor_7: (arena, obj, resultArena) =
>
{
  const result = kotlinObject(arena, obj)
  .7;
  return toArena(resultArena, result);
}
});
