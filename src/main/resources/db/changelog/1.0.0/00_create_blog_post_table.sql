-- liquibase formatted sql logicalFilePath:graphql_docs/db_changelog.xml
-- changeset mikhail_shumenko:1.0.0-00_create_blog_post_table.sql
-- comment: Create graphql_docs.blog_post table

create table if not exists public.blog_post
(
    id    serial       not null
        primary key,
    title varchar(255) not null
);

-- rollback DROP TABLE public.blog_post;
