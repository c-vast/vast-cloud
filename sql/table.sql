create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY, -- 客户端应用的账号
  resource_ids VARCHAR(256),		-- 客户端应用可访问的资源服务器列表,(空代表所有资源服务器都可以访问)
  client_secret VARCHAR(256),	-- 客户端应用的密码
  scope VARCHAR(256),	-- 资源服务器拥有的所有权限列表 (get add delete update)
  authorized_grant_types VARCHAR(256), -- 客户端支持的授权码模式列表
  web_server_redirect_uri VARCHAR(256), -- 授权码模式,申请授权码后重定向的uri.
  authorities VARCHAR(256),
  access_token_validity INTEGER,   -- 设置颁发token的有效期
  refresh_token_validity INTEGER,  -- 颁发refresh_token的有效期(不设置不会同时颁发refresh_token)
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)     -- 设置为true,授权码模式下自动授权
);
CREATE TABLE `t_sys_userinfo` (
  `id` bigint NOT NULL,
   `nickname` varchar(32) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `email` varchar(50) DEFAULT '' NOT NULL,
  `mobile` varchar(20) DEFAULT '' NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
);

