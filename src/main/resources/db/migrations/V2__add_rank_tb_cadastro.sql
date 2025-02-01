-- V2: Migration to add RANK column at tb_cadastro

ALTER TABLE tb_cadastro ADD COLUMN rank VARCHAR(255);