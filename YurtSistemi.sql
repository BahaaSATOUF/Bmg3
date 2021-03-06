PGDMP         "        
    	    y            YurtSistemi    14.0    14.0 y    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    18273    YurtSistemi    DATABASE     q   CREATE DATABASE "YurtSistemi" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1256';
    DROP DATABASE "YurtSistemi";
                postgres    false                        3079    18274    hstore 	   EXTENSION     :   CREATE EXTENSION IF NOT EXISTS hstore WITH SCHEMA public;
    DROP EXTENSION hstore;
                   false            ?           0    0    EXTENSION hstore    COMMENT     S   COMMENT ON EXTENSION hstore IS 'data type for storing sets of (key, value) pairs';
                        false    2            /           1255    18402    yemek_degistir()    FUNCTION       CREATE FUNCTION public.yemek_degistir() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
IF NEW.yemek_listesi <> OLD.yemek_listesi THEN
INSERT INTO degisiklik(eski_liste,guncelenen_liste,degistirldi)
VALUES(OLD.yemek_listesi,new.yemek_listesi,now());
END IF;
RETURN NEW;
END;
$$;
 '   DROP FUNCTION public.yemek_degistir();
       public          postgres    false            ?            1259    18403    calisan    TABLE     ?   CREATE TABLE public.calisan (
    tc character varying(11) NOT NULL,
    isim character varying(20),
    telefon_no character varying(11),
    maas integer
);
    DROP TABLE public.calisan;
       public         heap    postgres    false            ?            1259    18408    calisan_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.calisan_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.calisan_id_seq;
       public          postgres    false    210            ?           0    0    calisan_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.calisan_id_seq OWNED BY public.calisan.tc;
          public          postgres    false    211            ?            1259    18409 
   degisiklik    TABLE     ?   CREATE TABLE public.degisiklik (
    id integer NOT NULL,
    eski_liste character varying NOT NULL,
    guncelenen_liste character varying NOT NULL,
    degistirldi date NOT NULL
);
    DROP TABLE public.degisiklik;
       public         heap    postgres    false            ?            1259    18414    degisiklik_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.degisiklik_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.degisiklik_id_seq;
       public          postgres    false    212            ?           0    0    degisiklik_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.degisiklik_id_seq OWNED BY public.degisiklik.id;
          public          postgres    false    213            ?            1259    18415    etkinlik    TABLE     ?   CREATE TABLE public.etkinlik (
    etkinlik_id integer NOT NULL,
    sunan_hoca character varying(20) NOT NULL,
    etkinlik_turu character varying(20) NOT NULL,
    aciklama text
);
    DROP TABLE public.etkinlik;
       public         heap    postgres    false            ?            1259    18420    etkinlik_etkinlik_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.etkinlik_etkinlik_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.etkinlik_etkinlik_id_seq;
       public          postgres    false    214            ?           0    0    etkinlik_etkinlik_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.etkinlik_etkinlik_id_seq OWNED BY public.etkinlik.etkinlik_id;
          public          postgres    false    215            ?            1259    18421    kat    TABLE     W   CREATE TABLE public.kat (
    kat_numarasi integer NOT NULL,
    oda_sayisi integer
);
    DROP TABLE public.kat;
       public         heap    postgres    false            ?            1259    18424    kitablik    TABLE     ?   CREATE TABLE public.kitablik (
    kitap_id integer NOT NULL,
    kitap_adi character varying(20) NOT NULL,
    yazar character varying(20) NOT NULL
);
    DROP TABLE public.kitablik;
       public         heap    postgres    false            ?            1259    18427    kitablik_kitap_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kitablik_kitap_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.kitablik_kitap_id_seq;
       public          postgres    false    217            ?           0    0    kitablik_kitap_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.kitablik_kitap_id_seq OWNED BY public.kitablik.kitap_id;
          public          postgres    false    218            ?            1259    18428    kural    TABLE     k   CREATE TABLE public.kural (
    kural_id integer NOT NULL,
    aciklama character varying(100) NOT NULL
);
    DROP TABLE public.kural;
       public         heap    postgres    false            ?            1259    18431    kural_beliritme    TABLE     a   CREATE TABLE public.kural_beliritme (
    yonetici_id character varying,
    kural_no integer
);
 #   DROP TABLE public.kural_beliritme;
       public         heap    postgres    false            ?            1259    18436    kural_kural_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kural_kural_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.kural_kural_id_seq;
       public          postgres    false    219            ?           0    0    kural_kural_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.kural_kural_id_seq OWNED BY public.kural.kural_id;
          public          postgres    false    221            ?            1259    18437    muhasebe_personeli    TABLE     F   CREATE TABLE public.muhasebe_personeli (
)
INHERITS (public.calisan);
 &   DROP TABLE public.muhasebe_personeli;
       public         heap    postgres    false    210            ?            1259    18442    oda    TABLE     s   CREATE TABLE public.oda (
    oda_numarasi integer NOT NULL,
    yatak_sayisi integer,
    kat_numarasi integer
);
    DROP TABLE public.oda;
       public         heap    postgres    false            ?            1259    18445    odeme    TABLE     ?   CREATE TABLE public.odeme (
    ogrenci_no integer,
    muhsip_tc character varying,
    odeme_miktari character varying,
    odeme_tarihi date
);
    DROP TABLE public.odeme;
       public         heap    postgres    false            ?            1259    18450    ogrenci    TABLE     ?   CREATE TABLE public.ogrenci (
    ogrenci_no integer NOT NULL,
    ogrenci_adi character varying(20) NOT NULL,
    ogrenci_soyad character varying(20) NOT NULL,
    telefon_no character varying(11) NOT NULL,
    oda_numarasi integer
);
    DROP TABLE public.ogrenci;
       public         heap    postgres    false            ?            1259    18453    ogrenci_etkinlik    TABLE     c   CREATE TABLE public.ogrenci_etkinlik (
    ogrenci_no integer,
    etkinlik_id integer NOT NULL
);
 $   DROP TABLE public.ogrenci_etkinlik;
       public         heap    postgres    false            ?            1259    18456 "   ogrenci_etkinlik_e_etkinlik_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ogrenci_etkinlik_e_etkinlik_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.ogrenci_etkinlik_e_etkinlik_id_seq;
       public          postgres    false    226            ?           0    0 "   ogrenci_etkinlik_e_etkinlik_id_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.ogrenci_etkinlik_e_etkinlik_id_seq OWNED BY public.ogrenci_etkinlik.etkinlik_id;
          public          postgres    false    227            ?            1259    18457 !   ogrenci_etkinlik_e_ogrenci_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ogrenci_etkinlik_e_ogrenci_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.ogrenci_etkinlik_e_ogrenci_id_seq;
       public          postgres    false    226                        0    0 !   ogrenci_etkinlik_e_ogrenci_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.ogrenci_etkinlik_e_ogrenci_id_seq OWNED BY public.ogrenci_etkinlik.ogrenci_no;
          public          postgres    false    228            ?            1259    18458    ogrenci_kitap    TABLE     f   CREATE TABLE public.ogrenci_kitap (
    ogrenci_no integer NOT NULL,
    kitap_id integer NOT NULL
);
 !   DROP TABLE public.ogrenci_kitap;
       public         heap    postgres    false            ?            1259    18461    ogrenci_kitap_a_kitap_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ogrenci_kitap_a_kitap_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.ogrenci_kitap_a_kitap_id_seq;
       public          postgres    false    229                       0    0    ogrenci_kitap_a_kitap_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.ogrenci_kitap_a_kitap_id_seq OWNED BY public.ogrenci_kitap.kitap_id;
          public          postgres    false    230            ?            1259    18462    ogrenci_kitap_a_ogrenci_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ogrenci_kitap_a_ogrenci_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.ogrenci_kitap_a_ogrenci_id_seq;
       public          postgres    false    229                       0    0    ogrenci_kitap_a_ogrenci_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.ogrenci_kitap_a_ogrenci_id_seq OWNED BY public.ogrenci_kitap.ogrenci_no;
          public          postgres    false    231            ?            1259    18463    ogrenci_ogrenci_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ogrenci_ogrenci_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.ogrenci_ogrenci_id_seq;
       public          postgres    false    225                       0    0    ogrenci_ogrenci_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.ogrenci_ogrenci_id_seq OWNED BY public.ogrenci.ogrenci_no;
          public          postgres    false    232            ?            1259    18464    ogrenci_spor    TABLE     ?   CREATE TABLE public.ogrenci_spor (
    ogrenci_no integer NOT NULL,
    abone_baslangic_tarihi date,
    abone_bitis_tarihi date
);
     DROP TABLE public.ogrenci_spor;
       public         heap    postgres    false            ?            1259    18467    ogrenci_spor_s_ogrenci_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.ogrenci_spor_s_ogrenci_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.ogrenci_spor_s_ogrenci_id_seq;
       public          postgres    false    233                       0    0    ogrenci_spor_s_ogrenci_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.ogrenci_spor_s_ogrenci_id_seq OWNED BY public.ogrenci_spor.ogrenci_no;
          public          postgres    false    234            ?            1259    18468    spor_salonu    TABLE     ?   CREATE TABLE public.spor_salonu (
    gun date NOT NULL,
    saat time(4) without time zone,
    spor_turu character varying(30)
);
    DROP TABLE public.spor_salonu;
       public         heap    postgres    false            ?            1259    18471    temizlik_personeli    TABLE     ?   CREATE TABLE public.temizlik_personeli (
    kat_numarasi integer,
    muhaseip_tc character varying(11)
)
INHERITS (public.calisan);
 &   DROP TABLE public.temizlik_personeli;
       public         heap    postgres    false    210            ?            1259    18476 	   yemekhane    TABLE     m   CREATE TABLE public.yemekhane (
    yemek_listesi character varying(50) NOT NULL,
    tarih date NOT NULL
);
    DROP TABLE public.yemekhane;
       public         heap    postgres    false            ?            1259    18479    yemekhane_personeli    TABLE     l   CREATE TABLE public.yemekhane_personeli (
    muhasip_tc character varying(11)
)
INHERITS (public.calisan);
 '   DROP TABLE public.yemekhane_personeli;
       public         heap    postgres    false    210            ?            1259    18484    yonetim_personeli    TABLE     j   CREATE TABLE public.yonetim_personeli (
    muhasip_tc character varying(11)
)
INHERITS (public.calisan);
 %   DROP TABLE public.yonetim_personeli;
       public         heap    postgres    false    210                       2604    18489 
   calisan tc    DEFAULT     h   ALTER TABLE ONLY public.calisan ALTER COLUMN tc SET DEFAULT nextval('public.calisan_id_seq'::regclass);
 9   ALTER TABLE public.calisan ALTER COLUMN tc DROP DEFAULT;
       public          postgres    false    211    210                       2604    18490    degisiklik id    DEFAULT     n   ALTER TABLE ONLY public.degisiklik ALTER COLUMN id SET DEFAULT nextval('public.degisiklik_id_seq'::regclass);
 <   ALTER TABLE public.degisiklik ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    212                       2604    18491    etkinlik etkinlik_id    DEFAULT     |   ALTER TABLE ONLY public.etkinlik ALTER COLUMN etkinlik_id SET DEFAULT nextval('public.etkinlik_etkinlik_id_seq'::regclass);
 C   ALTER TABLE public.etkinlik ALTER COLUMN etkinlik_id DROP DEFAULT;
       public          postgres    false    215    214                       2604    18493    kural kural_id    DEFAULT     p   ALTER TABLE ONLY public.kural ALTER COLUMN kural_id SET DEFAULT nextval('public.kural_kural_id_seq'::regclass);
 =   ALTER TABLE public.kural ALTER COLUMN kural_id DROP DEFAULT;
       public          postgres    false    221    219                       2604    18494    muhasebe_personeli tc    DEFAULT     s   ALTER TABLE ONLY public.muhasebe_personeli ALTER COLUMN tc SET DEFAULT nextval('public.calisan_id_seq'::regclass);
 D   ALTER TABLE public.muhasebe_personeli ALTER COLUMN tc DROP DEFAULT;
       public          postgres    false    211    222                       2604    18495    ogrenci ogrenci_no    DEFAULT     x   ALTER TABLE ONLY public.ogrenci ALTER COLUMN ogrenci_no SET DEFAULT nextval('public.ogrenci_ogrenci_id_seq'::regclass);
 A   ALTER TABLE public.ogrenci ALTER COLUMN ogrenci_no DROP DEFAULT;
       public          postgres    false    232    225                       2604    18496    ogrenci_etkinlik ogrenci_no    DEFAULT     ?   ALTER TABLE ONLY public.ogrenci_etkinlik ALTER COLUMN ogrenci_no SET DEFAULT nextval('public.ogrenci_etkinlik_e_ogrenci_id_seq'::regclass);
 J   ALTER TABLE public.ogrenci_etkinlik ALTER COLUMN ogrenci_no DROP DEFAULT;
       public          postgres    false    228    226                       2604    18497    ogrenci_etkinlik etkinlik_id    DEFAULT     ?   ALTER TABLE ONLY public.ogrenci_etkinlik ALTER COLUMN etkinlik_id SET DEFAULT nextval('public.ogrenci_etkinlik_e_etkinlik_id_seq'::regclass);
 K   ALTER TABLE public.ogrenci_etkinlik ALTER COLUMN etkinlik_id DROP DEFAULT;
       public          postgres    false    227    226                       2604    18498    ogrenci_kitap ogrenci_no    DEFAULT     ?   ALTER TABLE ONLY public.ogrenci_kitap ALTER COLUMN ogrenci_no SET DEFAULT nextval('public.ogrenci_kitap_a_ogrenci_id_seq'::regclass);
 G   ALTER TABLE public.ogrenci_kitap ALTER COLUMN ogrenci_no DROP DEFAULT;
       public          postgres    false    231    229                       2604    18499    ogrenci_kitap kitap_id    DEFAULT     ?   ALTER TABLE ONLY public.ogrenci_kitap ALTER COLUMN kitap_id SET DEFAULT nextval('public.ogrenci_kitap_a_kitap_id_seq'::regclass);
 E   ALTER TABLE public.ogrenci_kitap ALTER COLUMN kitap_id DROP DEFAULT;
       public          postgres    false    230    229                       2604    18500    ogrenci_spor ogrenci_no    DEFAULT     ?   ALTER TABLE ONLY public.ogrenci_spor ALTER COLUMN ogrenci_no SET DEFAULT nextval('public.ogrenci_spor_s_ogrenci_id_seq'::regclass);
 F   ALTER TABLE public.ogrenci_spor ALTER COLUMN ogrenci_no DROP DEFAULT;
       public          postgres    false    234    233                       2604    18501    temizlik_personeli tc    DEFAULT     s   ALTER TABLE ONLY public.temizlik_personeli ALTER COLUMN tc SET DEFAULT nextval('public.calisan_id_seq'::regclass);
 D   ALTER TABLE public.temizlik_personeli ALTER COLUMN tc DROP DEFAULT;
       public          postgres    false    236    211                       2604    18502    yemekhane_personeli tc    DEFAULT     t   ALTER TABLE ONLY public.yemekhane_personeli ALTER COLUMN tc SET DEFAULT nextval('public.calisan_id_seq'::regclass);
 E   ALTER TABLE public.yemekhane_personeli ALTER COLUMN tc DROP DEFAULT;
       public          postgres    false    238    211                       2604    18503    yonetim_personeli tc    DEFAULT     r   ALTER TABLE ONLY public.yonetim_personeli ALTER COLUMN tc SET DEFAULT nextval('public.calisan_id_seq'::regclass);
 C   ALTER TABLE public.yonetim_personeli ALTER COLUMN tc DROP DEFAULT;
       public          postgres    false    239    211            ?          0    18403    calisan 
   TABLE DATA           =   COPY public.calisan (tc, isim, telefon_no, maas) FROM stdin;
    public          postgres    false    210   e?       ?          0    18409 
   degisiklik 
   TABLE DATA           S   COPY public.degisiklik (id, eski_liste, guncelenen_liste, degistirldi) FROM stdin;
    public          postgres    false    212   ??       ?          0    18415    etkinlik 
   TABLE DATA           T   COPY public.etkinlik (etkinlik_id, sunan_hoca, etkinlik_turu, aciklama) FROM stdin;
    public          postgres    false    214   ??       ?          0    18421    kat 
   TABLE DATA           7   COPY public.kat (kat_numarasi, oda_sayisi) FROM stdin;
    public          postgres    false    216   ??       ?          0    18424    kitablik 
   TABLE DATA           >   COPY public.kitablik (kitap_id, kitap_adi, yazar) FROM stdin;
    public          postgres    false    217   ٌ       ?          0    18428    kural 
   TABLE DATA           3   COPY public.kural (kural_id, aciklama) FROM stdin;
    public          postgres    false    219   ?       ?          0    18431    kural_beliritme 
   TABLE DATA           @   COPY public.kural_beliritme (yonetici_id, kural_no) FROM stdin;
    public          postgres    false    220   1?       ?          0    18437    muhasebe_personeli 
   TABLE DATA           H   COPY public.muhasebe_personeli (tc, isim, telefon_no, maas) FROM stdin;
    public          postgres    false    222   N?       ?          0    18442    oda 
   TABLE DATA           G   COPY public.oda (oda_numarasi, yatak_sayisi, kat_numarasi) FROM stdin;
    public          postgres    false    223   k?       ?          0    18445    odeme 
   TABLE DATA           S   COPY public.odeme (ogrenci_no, muhsip_tc, odeme_miktari, odeme_tarihi) FROM stdin;
    public          postgres    false    224   ??       ?          0    18450    ogrenci 
   TABLE DATA           c   COPY public.ogrenci (ogrenci_no, ogrenci_adi, ogrenci_soyad, telefon_no, oda_numarasi) FROM stdin;
    public          postgres    false    225   ??       ?          0    18453    ogrenci_etkinlik 
   TABLE DATA           C   COPY public.ogrenci_etkinlik (ogrenci_no, etkinlik_id) FROM stdin;
    public          postgres    false    226          ?          0    18458    ogrenci_kitap 
   TABLE DATA           =   COPY public.ogrenci_kitap (ogrenci_no, kitap_id) FROM stdin;
    public          postgres    false    229   ߍ       ?          0    18464    ogrenci_spor 
   TABLE DATA           ^   COPY public.ogrenci_spor (ogrenci_no, abone_baslangic_tarihi, abone_bitis_tarihi) FROM stdin;
    public          postgres    false    233   ??       ?          0    18468    spor_salonu 
   TABLE DATA           ;   COPY public.spor_salonu (gun, saat, spor_turu) FROM stdin;
    public          postgres    false    235   ?       ?          0    18471    temizlik_personeli 
   TABLE DATA           c   COPY public.temizlik_personeli (tc, isim, telefon_no, maas, kat_numarasi, muhaseip_tc) FROM stdin;
    public          postgres    false    236   6?       ?          0    18476 	   yemekhane 
   TABLE DATA           9   COPY public.yemekhane (yemek_listesi, tarih) FROM stdin;
    public          postgres    false    237   S?       ?          0    18479    yemekhane_personeli 
   TABLE DATA           U   COPY public.yemekhane_personeli (tc, isim, telefon_no, maas, muhasip_tc) FROM stdin;
    public          postgres    false    238   p?       ?          0    18484    yonetim_personeli 
   TABLE DATA           S   COPY public.yonetim_personeli (tc, isim, telefon_no, maas, muhasip_tc) FROM stdin;
    public          postgres    false    239   ??                  0    0    calisan_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.calisan_id_seq', 2, true);
          public          postgres    false    211                       0    0    degisiklik_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.degisiklik_id_seq', 3, true);
          public          postgres    false    213                       0    0    etkinlik_etkinlik_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.etkinlik_etkinlik_id_seq', 1, false);
          public          postgres    false    215                       0    0    kitablik_kitap_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.kitablik_kitap_id_seq', 1, true);
          public          postgres    false    218            	           0    0    kural_kural_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.kural_kural_id_seq', 1, false);
          public          postgres    false    221            
           0    0 "   ogrenci_etkinlik_e_etkinlik_id_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.ogrenci_etkinlik_e_etkinlik_id_seq', 1, false);
          public          postgres    false    227                       0    0 !   ogrenci_etkinlik_e_ogrenci_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.ogrenci_etkinlik_e_ogrenci_id_seq', 1, false);
          public          postgres    false    228                       0    0    ogrenci_kitap_a_kitap_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.ogrenci_kitap_a_kitap_id_seq', 1, false);
          public          postgres    false    230                       0    0    ogrenci_kitap_a_ogrenci_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.ogrenci_kitap_a_ogrenci_id_seq', 1, false);
          public          postgres    false    231                       0    0    ogrenci_ogrenci_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.ogrenci_ogrenci_id_seq', 1, false);
          public          postgres    false    232                       0    0    ogrenci_spor_s_ogrenci_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.ogrenci_spor_s_ogrenci_id_seq', 1, false);
          public          postgres    false    234                        2606    18505    calisan calisan_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.calisan
    ADD CONSTRAINT calisan_pkey PRIMARY KEY (tc);
 >   ALTER TABLE ONLY public.calisan DROP CONSTRAINT calisan_pkey;
       public            postgres    false    210            "           2606    18507    degisiklik degisiklik_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.degisiklik
    ADD CONSTRAINT degisiklik_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.degisiklik DROP CONSTRAINT degisiklik_pkey;
       public            postgres    false    212            $           2606    18509    etkinlik etkinlik_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.etkinlik
    ADD CONSTRAINT etkinlik_pkey PRIMARY KEY (etkinlik_id);
 @   ALTER TABLE ONLY public.etkinlik DROP CONSTRAINT etkinlik_pkey;
       public            postgres    false    214            &           2606    18511    kat kat_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.kat
    ADD CONSTRAINT kat_pkey PRIMARY KEY (kat_numarasi);
 6   ALTER TABLE ONLY public.kat DROP CONSTRAINT kat_pkey;
       public            postgres    false    216            (           2606    18513    kitablik kitablik_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.kitablik
    ADD CONSTRAINT kitablik_pkey PRIMARY KEY (kitap_id);
 @   ALTER TABLE ONLY public.kitablik DROP CONSTRAINT kitablik_pkey;
       public            postgres    false    217            *           2606    18515    kural kural_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.kural
    ADD CONSTRAINT kural_pkey PRIMARY KEY (kural_id);
 :   ALTER TABLE ONLY public.kural DROP CONSTRAINT kural_pkey;
       public            postgres    false    219            ,           2606    18517 *   muhasebe_personeli muhasebe_personeli_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.muhasebe_personeli
    ADD CONSTRAINT muhasebe_personeli_pkey PRIMARY KEY (tc);
 T   ALTER TABLE ONLY public.muhasebe_personeli DROP CONSTRAINT muhasebe_personeli_pkey;
       public            postgres    false    222            .           2606    18519    oda oda_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.oda
    ADD CONSTRAINT oda_pkey PRIMARY KEY (oda_numarasi);
 6   ALTER TABLE ONLY public.oda DROP CONSTRAINT oda_pkey;
       public            postgres    false    223            0           2606    18521    ogrenci ogrenci_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.ogrenci
    ADD CONSTRAINT ogrenci_pkey PRIMARY KEY (ogrenci_no);
 >   ALTER TABLE ONLY public.ogrenci DROP CONSTRAINT ogrenci_pkey;
       public            postgres    false    225            2           2606    18523    spor_salonu spor_salonu_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.spor_salonu
    ADD CONSTRAINT spor_salonu_pkey PRIMARY KEY (gun);
 F   ALTER TABLE ONLY public.spor_salonu DROP CONSTRAINT spor_salonu_pkey;
       public            postgres    false    235            4           2606    18525 *   temizlik_personeli temizlik_personeli_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.temizlik_personeli
    ADD CONSTRAINT temizlik_personeli_pkey PRIMARY KEY (tc);
 T   ALTER TABLE ONLY public.temizlik_personeli DROP CONSTRAINT temizlik_personeli_pkey;
       public            postgres    false    236            8           2606    18527 ,   yemekhane_personeli yemekhane_personeli_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.yemekhane_personeli
    ADD CONSTRAINT yemekhane_personeli_pkey PRIMARY KEY (tc);
 V   ALTER TABLE ONLY public.yemekhane_personeli DROP CONSTRAINT yemekhane_personeli_pkey;
       public            postgres    false    238            6           2606    18529    yemekhane yemekhane_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.yemekhane
    ADD CONSTRAINT yemekhane_pkey PRIMARY KEY (tarih);
 B   ALTER TABLE ONLY public.yemekhane DROP CONSTRAINT yemekhane_pkey;
       public            postgres    false    237            :           2606    18531 )   yonetim_personeli yönetim_personeli_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY public.yonetim_personeli
    ADD CONSTRAINT "yönetim_personeli_pkey" PRIMARY KEY (tc);
 U   ALTER TABLE ONLY public.yonetim_personeli DROP CONSTRAINT "yönetim_personeli_pkey";
       public            postgres    false    239            I           2620    18532     yemekhane yemek_listesi_degistir    TRIGGER        CREATE TRIGGER yemek_listesi_degistir BEFORE UPDATE ON public.yemekhane FOR EACH ROW EXECUTE FUNCTION public.yemek_degistir();
 9   DROP TRIGGER yemek_listesi_degistir ON public.yemekhane;
       public          postgres    false    303    237            @           2606    18533     ogrenci_etkinlik iliski_etkinlik    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ogrenci_etkinlik
    ADD CONSTRAINT iliski_etkinlik FOREIGN KEY (etkinlik_id) REFERENCES public.etkinlik(etkinlik_id) NOT VALID;
 J   ALTER TABLE ONLY public.ogrenci_etkinlik DROP CONSTRAINT iliski_etkinlik;
       public          postgres    false    214    3364    226            B           2606    18538    ogrenci_kitap iliski_kitap    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ogrenci_kitap
    ADD CONSTRAINT iliski_kitap FOREIGN KEY (kitap_id) REFERENCES public.kitablik(kitap_id) NOT VALID;
 D   ALTER TABLE ONLY public.ogrenci_kitap DROP CONSTRAINT iliski_kitap;
       public          postgres    false    3368    217    229            >           2606    18543    odeme iliski_odeme    FK CONSTRAINT     ?   ALTER TABLE ONLY public.odeme
    ADD CONSTRAINT iliski_odeme FOREIGN KEY (ogrenci_no) REFERENCES public.ogrenci(ogrenci_no) ON UPDATE CASCADE ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.odeme DROP CONSTRAINT iliski_odeme;
       public          postgres    false    224    3376    225            C           2606    18548    ogrenci_kitap iliski_ogrenci    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ogrenci_kitap
    ADD CONSTRAINT iliski_ogrenci FOREIGN KEY (ogrenci_no) REFERENCES public.ogrenci(ogrenci_no) ON UPDATE CASCADE ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.ogrenci_kitap DROP CONSTRAINT iliski_ogrenci;
       public          postgres    false    225    229    3376            A           2606    18553    ogrenci_etkinlik iliski_ogrenci    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ogrenci_etkinlik
    ADD CONSTRAINT iliski_ogrenci FOREIGN KEY (ogrenci_no) REFERENCES public.ogrenci(ogrenci_no) ON UPDATE CASCADE ON DELETE CASCADE;
 I   ALTER TABLE ONLY public.ogrenci_etkinlik DROP CONSTRAINT iliski_ogrenci;
       public          postgres    false    3376    226    225            D           2606    18558    ogrenci_spor iliski_spor    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ogrenci_spor
    ADD CONSTRAINT iliski_spor FOREIGN KEY (ogrenci_no) REFERENCES public.ogrenci(ogrenci_no) ON UPDATE CASCADE ON DELETE CASCADE;
 B   ALTER TABLE ONLY public.ogrenci_spor DROP CONSTRAINT iliski_spor;
       public          postgres    false    225    3376    233            =           2606    18563    oda kat_iliskisi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.oda
    ADD CONSTRAINT kat_iliskisi FOREIGN KEY (kat_numarasi) REFERENCES public.kat(kat_numarasi) NOT VALID;
 :   ALTER TABLE ONLY public.oda DROP CONSTRAINT kat_iliskisi;
       public          postgres    false    216    3366    223            ;           2606    18568    kural_beliritme kural_iliskisi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.kural_beliritme
    ADD CONSTRAINT kural_iliskisi FOREIGN KEY (kural_no) REFERENCES public.kural(kural_id);
 H   ALTER TABLE ONLY public.kural_beliritme DROP CONSTRAINT kural_iliskisi;
       public          postgres    false    220    3370    219            G           2606    18573 $   yemekhane_personeli muhsebe_iliskisi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.yemekhane_personeli
    ADD CONSTRAINT muhsebe_iliskisi FOREIGN KEY (muhasip_tc) REFERENCES public.muhasebe_personeli(tc) NOT VALID;
 N   ALTER TABLE ONLY public.yemekhane_personeli DROP CONSTRAINT muhsebe_iliskisi;
       public          postgres    false    238    222    3372            E           2606    18578 #   temizlik_personeli muhsebe_iliskisi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.temizlik_personeli
    ADD CONSTRAINT muhsebe_iliskisi FOREIGN KEY (muhaseip_tc) REFERENCES public.muhasebe_personeli(tc) NOT VALID;
 M   ALTER TABLE ONLY public.temizlik_personeli DROP CONSTRAINT muhsebe_iliskisi;
       public          postgres    false    236    222    3372            H           2606    18583 "   yonetim_personeli muhsebe_iliskisi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.yonetim_personeli
    ADD CONSTRAINT muhsebe_iliskisi FOREIGN KEY (muhasip_tc) REFERENCES public.muhasebe_personeli(tc) NOT VALID;
 L   ALTER TABLE ONLY public.yonetim_personeli DROP CONSTRAINT muhsebe_iliskisi;
       public          postgres    false    3372    239    222            ?           2606    18588    ogrenci oda_numarasi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ogrenci
    ADD CONSTRAINT oda_numarasi FOREIGN KEY (oda_numarasi) REFERENCES public.oda(oda_numarasi) NOT VALID;
 >   ALTER TABLE ONLY public.ogrenci DROP CONSTRAINT oda_numarasi;
       public          postgres    false    225    3374    223            F           2606    18593    temizlik_personeli temizlik    FK CONSTRAINT     ?   ALTER TABLE ONLY public.temizlik_personeli
    ADD CONSTRAINT temizlik FOREIGN KEY (kat_numarasi) REFERENCES public.kat(kat_numarasi) NOT VALID;
 E   ALTER TABLE ONLY public.temizlik_personeli DROP CONSTRAINT temizlik;
       public          postgres    false    3366    216    236            <           2606    18598     kural_beliritme yonetim_iliskisi    FK CONSTRAINT     ?   ALTER TABLE ONLY public.kural_beliritme
    ADD CONSTRAINT yonetim_iliskisi FOREIGN KEY (yonetici_id) REFERENCES public.yonetim_personeli(tc) NOT VALID;
 J   ALTER TABLE ONLY public.kural_beliritme DROP CONSTRAINT yonetim_iliskisi;
       public          postgres    false    3386    220    239            ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?   +   x?3?,K-??L??MMI?2?Lˬ??????H?ML?????? ?
V      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?     