PGDMP      (    ;                {           pingwit_shop    14.8 (Debian 14.8-1.pgdg110+1)    15.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16604    pingwit_shop    DATABASE     w   CREATE DATABASE pingwit_shop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE pingwit_shop;
                pingwit    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                pingwit    false                       0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   pingwit    false    4            �            1259    16657    order_items    TABLE     �   CREATE TABLE public.order_items (
    id bigint,
    order_id bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity integer NOT NULL
);
    DROP TABLE public.order_items;
       public         heap    pingwit    false    4            �            1259    16640    orders    TABLE     �   CREATE TABLE public.orders (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    created_at date NOT NULL,
    status_id bigint NOT NULL,
    comment character varying(500)
);
    DROP TABLE public.orders;
       public         heap    pingwit    false    4            �            1259    16614    products    TABLE     �   CREATE TABLE public.products (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    description character varying(500),
    price numeric(9,2) NOT NULL
);
    DROP TABLE public.products;
       public         heap    pingwit    false    4            �            1259    16621    statuses    TABLE     �   CREATE TABLE public.statuses (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    description character varying(500)
);
    DROP TABLE public.statuses;
       public         heap    pingwit    false    4            �            1259    16605    users    TABLE     �   CREATE TABLE public.users (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    surname character varying(200) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(50) NOT NULL
);
    DROP TABLE public.users;
       public         heap    pingwit    false    4                      0    16657    order_items 
   TABLE DATA           I   COPY public.order_items (id, order_id, product_id, quantity) FROM stdin;
    public          pingwit    false    213   V       
          0    16640    orders 
   TABLE DATA           M   COPY public.orders (id, user_id, created_at, status_id, comment) FROM stdin;
    public          pingwit    false    212   2                 0    16614    products 
   TABLE DATA           @   COPY public.products (id, name, description, price) FROM stdin;
    public          pingwit    false    210   �       	          0    16621    statuses 
   TABLE DATA           9   COPY public.statuses (id, name, description) FROM stdin;
    public          pingwit    false    211   �                 0    16605    users 
   TABLE DATA           @   COPY public.users (id, name, surname, email, phone) FROM stdin;
    public          pingwit    false    209   P       w           2606    16646    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            pingwit    false    212            s           2606    16620    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            pingwit    false    210            u           2606    16627    statuses statuses_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.statuses
    ADD CONSTRAINT statuses_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.statuses DROP CONSTRAINT statuses_pkey;
       public            pingwit    false    211            o           2606    16613    users user_email_unique 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_email_unique UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT user_email_unique;
       public            pingwit    false    209            q           2606    16611    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            pingwit    false    209            z           2606    16660    order_items order_item_order_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_item_order_fk FOREIGN KEY (order_id) REFERENCES public.orders(id);
 I   ALTER TABLE ONLY public.order_items DROP CONSTRAINT order_item_order_fk;
       public          pingwit    false    3191    212    213            {           2606    16665 !   order_items order_item_product_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_item_product_fk FOREIGN KEY (product_id) REFERENCES public.products(id);
 K   ALTER TABLE ONLY public.order_items DROP CONSTRAINT order_item_product_fk;
       public          pingwit    false    213    3187    210            x           2606    16652    orders order_status_fk    FK CONSTRAINT     z   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT order_status_fk FOREIGN KEY (status_id) REFERENCES public.statuses(id);
 @   ALTER TABLE ONLY public.orders DROP CONSTRAINT order_status_fk;
       public          pingwit    false    212    3189    211            y           2606    16647    orders order_user_fk    FK CONSTRAINT     s   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT order_user_fk FOREIGN KEY (user_id) REFERENCES public.users(id);
 >   ALTER TABLE ONLY public.orders DROP CONSTRAINT order_user_fk;
       public          pingwit    false    3185    209    212               �   x^-���0ľ}���vv��s�r
!K����|2����<�h���/ԭS����~��ဏ��=S�9�
�+���X��n��9�C��D����v�槑Ɩ���.f3j}�M�jW؇(Hp�Pĸ��`[�A��lS}�V�	��&4 �� ek3 GɅ=���@�C���J���i~�~?�~ <z      
      x^U�A
1E��):���uF/���l�.Z���R����~@ q⭃E ��v+�B��m���'�'�ވŹ7��oKG�����}�&o�Z��<�LXc�����C�����48�m�f�q�'�         �   x^e�Aj�0EףS��#;M�L
ݕ�覛���dl����c9�E���� ³�T���hk���F�9�%�{���ib�	�Կ����h��;������X�����DA�ʲ�������%�r��׳x��Rﭲ�����r�Va��D!-r�
�@���@̽Pھ����	f�һqs��w�σ�,���L���M�}Ʋ������`�����[����(�8�S�>X���R?v�v%      	   q   x^34�t.JM,IM��/JI-RH���JK��K
3S��92aJ B&��y
)�9�e�E�P���
%�٩y
I�p9.CSN�:�-P}�@��8�RKJ���rEP.W� ڏ52         �  x^eRKO�0<o~�q��-  Q�'.�~Ɖ���y@��Y�B>�l_�;3;�`���`e��'��;l���߁.�RR
)2W�!�gߪ�8;ka,�Ƕ�:�	7��5�߬����'��[z|~>T�-���}�EX�{8����"'x/̀}��ڱ+�ќ�#OϝEx4m�8���yQ���|�H�X�8kd�$���������	���x�.5�T��ԙ�v��LM�$�w�L�"��17��+��}\��Jj�M���X�w8�0D����ZП$��o��f[C �?4���������]��hR-=���ST�����k��x�H�� E!�k��6�m�f9?�VZi�_�#�L�!�~�B��);��E�e_>�Ե     