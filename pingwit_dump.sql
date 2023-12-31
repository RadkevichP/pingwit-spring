PGDMP      6    %    	            {           pingwit    14.8 (Debian 14.8-1.pgdg110+1)    15.2 8    A           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            B           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            C           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            D           1262    16384    pingwit    DATABASE     r   CREATE DATABASE pingwit WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE pingwit;
                pingwit    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                pingwit    false            E           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   pingwit    false    5            �            1259    16472    address    TABLE     �   CREATE TABLE public.address (
    id bigint NOT NULL,
    city character varying(200) NOT NULL,
    street character varying(300) NOT NULL,
    house character varying(8) NOT NULL
);
    DROP TABLE public.address;
       public         heap    pingwit    false    5            �            1259    16477    address_id_seq    SEQUENCE     �   ALTER TABLE public.address ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.address_id_seq
    START WITH 1
    INCREMENT BY 4
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          pingwit    false    5    220            �            1259    16450 	   employees    TABLE     �   CREATE TABLE public.employees (
    id bigint NOT NULL,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    shop_id bigint NOT NULL,
    title character varying NOT NULL
);
    DROP TABLE public.employees;
       public         heap    pingwit    false    5            �            1259    16478    employees_id_seq    SEQUENCE     �   ALTER TABLE public.employees ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.employees_id_seq
    START WITH 2
    INCREMENT BY 3
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          pingwit    false    217    5            �            1259    16385    order_items    TABLE     �   CREATE TABLE public.order_items (
    id bigint NOT NULL,
    order_id bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity integer NOT NULL
);
    DROP TABLE public.order_items;
       public         heap    pingwit    false    5            �            1259    16440    order_items_id_seq    SEQUENCE     �   ALTER TABLE public.order_items ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.order_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          pingwit    false    5    209            �            1259    16388    orders    TABLE     �   CREATE TABLE public.orders (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    created_at date NOT NULL,
    status_id bigint,
    comment character varying(500)
);
    DROP TABLE public.orders;
       public         heap    pingwit    false    5            �            1259    16481    orders_id_seq    SEQUENCE     �   ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 4
    INCREMENT BY 9
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          pingwit    false    210    5            �            1259    16393    products    TABLE     �   CREATE TABLE public.products (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    description character varying(500),
    price numeric(9,2) NOT NULL
);
    DROP TABLE public.products;
       public         heap    pingwit    false    5            �            1259    16441    shops    TABLE     �   CREATE TABLE public.shops (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    address_id bigint NOT NULL,
    phone character varying NOT NULL
);
    DROP TABLE public.shops;
       public         heap    pingwit    false    5            �            1259    16479    shops_id_seq    SEQUENCE     �   ALTER TABLE public.shops ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.shops_id_seq
    START WITH 1
    INCREMENT BY 6
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          pingwit    false    5    216            �            1259    16398    statuses    TABLE     �   CREATE TABLE public.statuses (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    description character varying(500)
);
    DROP TABLE public.statuses;
       public         heap    pingwit    false    5            �            1259    16457    tags    TABLE     }   CREATE TABLE public.tags (
    id bigint NOT NULL,
    name character varying NOT NULL,
    description character varying
);
    DROP TABLE public.tags;
       public         heap    pingwit    false    5            �            1259    16480    tags_id_seq    SEQUENCE     �   ALTER TABLE public.tags ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tags_id_seq
    START WITH 2
    INCREMENT BY 7
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          pingwit    false    5    218            �            1259    16464    user_tag    TABLE     \   CREATE TABLE public.user_tag (
    users_id bigint NOT NULL,
    pags_id bigint NOT NULL
);
    DROP TABLE public.user_tag;
       public         heap    pingwit    false    5            �            1259    16403    users    TABLE     �   CREATE TABLE public.users (
    id bigint NOT NULL,
    name character varying(200) NOT NULL,
    surname character varying(200) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(50) NOT NULL
);
    DROP TABLE public.users;
       public         heap    pingwit    false    5            �            1259    16438    users_id_seq    SEQUENCE     �   ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1000
    INCREMENT BY 5
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          pingwit    false    5    213            9          0    16472    address 
   TABLE DATA           :   COPY public.address (id, city, street, house) FROM stdin;
    public          pingwit    false    220   *=       6          0    16450 	   employees 
   TABLE DATA           F   COPY public.employees (id, name, surname, shop_id, title) FROM stdin;
    public          pingwit    false    217   �=       .          0    16385    order_items 
   TABLE DATA           I   COPY public.order_items (id, order_id, product_id, quantity) FROM stdin;
    public          pingwit    false    209   ;>       /          0    16388    orders 
   TABLE DATA           M   COPY public.orders (id, user_id, created_at, status_id, comment) FROM stdin;
    public          pingwit    false    210   �?       0          0    16393    products 
   TABLE DATA           @   COPY public.products (id, name, description, price) FROM stdin;
    public          pingwit    false    211   &@       5          0    16441    shops 
   TABLE DATA           <   COPY public.shops (id, name, address_id, phone) FROM stdin;
    public          pingwit    false    216   AA       1          0    16398    statuses 
   TABLE DATA           9   COPY public.statuses (id, name, description) FROM stdin;
    public          pingwit    false    212   �A       7          0    16457    tags 
   TABLE DATA           5   COPY public.tags (id, name, description) FROM stdin;
    public          pingwit    false    218   *B       8          0    16464    user_tag 
   TABLE DATA           5   COPY public.user_tag (users_id, pags_id) FROM stdin;
    public          pingwit    false    219   GB       2          0    16403    users 
   TABLE DATA           @   COPY public.users (id, name, surname, email, phone) FROM stdin;
    public          pingwit    false    213   dB       F           0    0    address_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.address_id_seq', 9, true);
          public          pingwit    false    221            G           0    0    employees_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.employees_id_seq', 26, true);
          public          pingwit    false    222            H           0    0    order_items_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.order_items_id_seq', 5, true);
          public          pingwit    false    215            I           0    0    orders_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.orders_id_seq', 22, true);
          public          pingwit    false    225            J           0    0    shops_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.shops_id_seq', 13, true);
          public          pingwit    false    223            K           0    0    tags_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.tags_id_seq', 2, false);
          public          pingwit    false    224            L           0    0    users_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.users_id_seq', 1060, true);
          public          pingwit    false    214            �           2606    16677    address address_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public            pingwit    false    220            �           2606    16456    employees employees_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public            pingwit    false    217            �           2606    16409    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            pingwit    false    210            �           2606    16411    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            pingwit    false    211            �           2606    16449    shops shops_name_key 
   CONSTRAINT     O   ALTER TABLE ONLY public.shops
    ADD CONSTRAINT shops_name_key UNIQUE (name);
 >   ALTER TABLE ONLY public.shops DROP CONSTRAINT shops_name_key;
       public            pingwit    false    216            �           2606    16447    shops shops_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.shops
    ADD CONSTRAINT shops_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.shops DROP CONSTRAINT shops_pkey;
       public            pingwit    false    216            �           2606    16413    statuses statuses_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.statuses
    ADD CONSTRAINT statuses_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.statuses DROP CONSTRAINT statuses_pkey;
       public            pingwit    false    212            �           2606    16463    tags tags_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.tags
    ADD CONSTRAINT tags_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.tags DROP CONSTRAINT tags_pkey;
       public            pingwit    false    218            �           2606    16415    users user_email_unique 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT user_email_unique UNIQUE (email);
 A   ALTER TABLE ONLY public.users DROP CONSTRAINT user_email_unique;
       public            pingwit    false    213            �           2606    16417    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            pingwit    false    213            �           2606    16467    employees employee_shop_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employee_shop_fk FOREIGN KEY (shop_id) REFERENCES public.shops(id) NOT VALID;
 D   ALTER TABLE ONLY public.employees DROP CONSTRAINT employee_shop_fk;
       public          pingwit    false    216    3222    217            �           2606    16418    order_items order_item_order_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_item_order_fk FOREIGN KEY (order_id) REFERENCES public.orders(id);
 I   ALTER TABLE ONLY public.order_items DROP CONSTRAINT order_item_order_fk;
       public          pingwit    false    210    209    3210            �           2606    16423 !   order_items order_item_product_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.order_items
    ADD CONSTRAINT order_item_product_fk FOREIGN KEY (product_id) REFERENCES public.products(id);
 K   ALTER TABLE ONLY public.order_items DROP CONSTRAINT order_item_product_fk;
       public          pingwit    false    3212    209    211            �           2606    16428    orders order_status_fk    FK CONSTRAINT     z   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT order_status_fk FOREIGN KEY (status_id) REFERENCES public.statuses(id);
 @   ALTER TABLE ONLY public.orders DROP CONSTRAINT order_status_fk;
       public          pingwit    false    3214    212    210            �           2606    16433    orders order_user_fk    FK CONSTRAINT     s   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT order_user_fk FOREIGN KEY (user_id) REFERENCES public.users(id);
 >   ALTER TABLE ONLY public.orders DROP CONSTRAINT order_user_fk;
       public          pingwit    false    210    3218    213            �           2606    16678    shops shop_address_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.shops
    ADD CONSTRAINT shop_address_fk FOREIGN KEY (address_id) REFERENCES public.address(id) NOT VALID;
 ?   ALTER TABLE ONLY public.shops DROP CONSTRAINT shop_address_fk;
       public          pingwit    false    220    216    3228            9   H   x^3�����,-��I�,.K-�4�2�O,*N,���/NJed�s��sYr��'� ���s9���b���� �6�      6   �   x^]�O�@���o?L��ǮITP���2蠋�n�j�o=(�uޙ�p��=N�C�!C%;�B��VO�ȷ�P�(�|먵NlpfU���W*TRb����s&D�_$�8�1Ta���1㢹�U9[�W�qa4ǝ�
��o���h��L���z�O��S!eS���c&����J&      .   8  x^�[��0E��bF�H�2�_��vs��:����8�y>�%_n��k����	��n�����{?��6�߆^���#л�%rF���	npZ�6+6�	"*�Z��Oh����[<�\�b��X�n�Pm�	V"�Dp��.�ۖ$�D�	lc}�
l��`e��X�eɎ�xl�a��ec���ԯ{�����)��V�7�(���[ ��o(з *�
�+XW�nѺE��g�Y�L�C�N�:E�5I�IzV�C�u���R�R�J��Ջְ����&}�y�&��q��r0�      /   �   x^]O�
�0|N����J��Mb�>�eb��YZ�����$�p��c v��KAQ}�K�rz\�ӭ��-��<=u~Yf���L�E�f)����]�0���E�F1�ov@��MPm�H��\�1j��7�EW��O���Ia�"��	3�      0     x^e�AO�0���_�/h�ºp\M<i$����ƥ��6P4��;�ư�&sxo�M�C�g�(��>(��u��U4:_E\��g�.�Fv��\���h{�:&��e$f�l�.d��aC�!ܓ�fg���X#S_�M��U��Y�{P�������!s2�Za��H>-p��@���A\s��}#�����f�%wc�DSoß��,����L1:�b���CC�R`����z����gh�r<Zn��Q�8�C������f�O�@��Q�Z)���{      5   X   x^3���K/�,�����,-�4�4��0775535�2�K�''�s�rZ����s#��s�
,9���&@�ff\1z\\\ �Z      1   q   x^34�t.JM,IM��/JI-RH���JK��K
3S��92aJ B&��y
)�9�e�E�P���
%�٩y
I�p9.CSN�:�-P}�@��8�RKJ���rEP.W� ڏ52      7      x^����� � �      8      x^����� � �      2     x^eS�n�0=_�/�b���h�ݕ�JE����L,��H7��CH�H̛yo<�r<�r�9{��Ɋ�z����L�8�8<��S��+k�)f�B>�"x��?x��A���x��	O����>�i켨�JÛj[�Cؔ'8۳}���H��o�a��}U_��mڙА�A��Ϻ@xWU]����a�K�)���PG�P`�3 �cK��6��xF��Pc��	�Tr���H9!CWu���*��ھ�7K�(�'`^�-r��#��nٴLb)'�,�~T��t;��b�RP�o��I�F�Jh��N�;��r ,��B��3���{92���h
X�pO�b�4�~��H�E_�K�]	[c�f���k'2�$?�X��Ά�۹e#�Tz��P���eM�}=���G\|�B�!-a�M7ם:�?	��~ �	A��<���;��h�HX�0�_$�u�db��JN*��N��>���>�ҢK�	�OO��|]���cl0�⻞���� ��J:     